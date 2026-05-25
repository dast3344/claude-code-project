package com.usermanagement.service;

import com.usermanagement.dto.UserCreateRequest;
import com.usermanagement.dto.UserDTO;
import com.usermanagement.dto.UserUpdateRequest;
import com.usermanagement.entity.User;
import com.usermanagement.entity.UserRole;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public Page<UserDTO> searchUsers(String keyword, User.UserStatus status, Long departmentId, Pageable pageable) {
        return userRepository.searchUsers(keyword, status, departmentId, pageable)
                .map(UserDTO::fromEntity);
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
        return UserDTO.fromEntity(user);
    }

    @Transactional
    public UserDTO createUser(UserCreateRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("用户名已存在");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("邮箱已存在");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setAvatar(request.getAvatar());
        user.setBio(request.getBio());
        user.setDepartmentId(request.getDepartmentId());

        User savedUser = userRepository.save(user);

        if (request.getRoleIds() != null && !request.getRoleIds().isEmpty()) {
            for (Long roleId : request.getRoleIds()) {
                UserRole userRole = new UserRole();
                UserRole.UserRoleId id = new UserRole.UserRoleId();
                id.setUserId(savedUser.getId());
                id.setRoleId(roleId);
                userRole.setId(id);
                userRoleRepository.save(userRole);
            }
        }

        return UserDTO.fromEntity(savedUser);
    }

    @Transactional
    public UserDTO updateUser(Long id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在"));

        if (request.getEmail() != null && !request.getEmail().equals(user.getEmail())) {
            if (userRepository.existsByEmail(request.getEmail())) {
                throw new RuntimeException("邮箱已存在");
            }
            user.setEmail(request.getEmail());
        }

        if (request.getPhone() != null) {
            user.setPhone(request.getPhone());
        }
        if (request.getFullName() != null) {
            user.setFullName(request.getFullName());
        }
        if (request.getAvatar() != null) {
            user.setAvatar(request.getAvatar());
        }
        if (request.getBio() != null) {
            user.setBio(request.getBio());
        }
        if (request.getDepartmentId() != null) {
            user.setDepartmentId(request.getDepartmentId());
        }
        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        User savedUser = userRepository.save(user);

        if (request.getRoleIds() != null) {
            userRoleRepository.deleteByUserId(id);
            for (Long roleId : request.getRoleIds()) {
                UserRole userRole = new UserRole();
                UserRole.UserRoleId userRoleId = new UserRole.UserRoleId();
                userRoleId.setUserId(id);
                userRoleId.setRoleId(roleId);
                userRole.setId(userRoleId);
                userRoleRepository.save(userRole);
            }
        }

        return UserDTO.fromEntity(savedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("用户不存在");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUserStatus(Long id, User.UserStatus status) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在"));
        user.setStatus(status);
        userRepository.save(user);
    }
}
