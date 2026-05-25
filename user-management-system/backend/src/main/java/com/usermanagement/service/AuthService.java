package com.usermanagement.service;

import com.usermanagement.dto.LoginRequest;
import com.usermanagement.dto.LoginResponse;
import com.usermanagement.dto.UserDTO;
import com.usermanagement.entity.OperationLog;
import com.usermanagement.entity.User;
import com.usermanagement.repository.OperationLogRepository;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.repository.UserRoleRepository;
import com.usermanagement.util.JwtUtil;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final OperationLogRepository operationLogRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public LoginResponse login(LoginRequest request, HttpServletRequest httpRequest) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("用户名或密码错误"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }

        if (user.getStatus() == User.UserStatus.DISABLED) {
            throw new RuntimeException("账号已被禁用");
        }

        user.setLastLoginTime(LocalDateTime.now());
        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getId(), user.getUsername());

        OperationLog log = new OperationLog();
        log.setUserId(user.getId());
        log.setOperation("LOGIN");
        log.setResource("AUTH");
        log.setDetails("用户登录");
        log.setIpAddress(getClientIp(httpRequest));
        operationLogRepository.save(log);

        UserDTO userDTO = UserDTO.fromEntity(user);
        List<String> roles = getUserRoles(user.getId());
        userDTO.setRoles(roles);

        return new LoginResponse(token, userDTO);
    }

    private List<String> getUserRoles(Long userId) {
        return userRoleRepository.findByUserId(userId).stream()
                .map(ur -> {
                    return userRepository.findById(ur.getId().getUserId())
                            .map(u -> u.getUsername())
                            .orElse("");
                })
                .collect(Collectors.toList());
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty()) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
