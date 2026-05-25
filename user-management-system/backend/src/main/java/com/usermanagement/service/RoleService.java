package com.usermanagement.service;

import com.usermanagement.entity.Role;
import com.usermanagement.repository.RoleRepository;
import com.usermanagement.repository.RolePermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RolePermissionRepository rolePermissionRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("角色不存在"));
    }

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("角色不存在"));
    }

    public List<Role> getUserRoles(Long userId) {
        return roleRepository.findByUserId(userId);
    }

    @Transactional
    public Role createRole(Role role) {
        if (roleRepository.existsByName(role.getName())) {
            throw new RuntimeException("角色名称已存在");
        }
        return roleRepository.save(role);
    }

    @Transactional
    public Role updateRole(Long id, Role role) {
        Role existing = getRoleById(id);
        if (!existing.getName().equals(role.getName()) && roleRepository.existsByName(role.getName())) {
            throw new RuntimeException("角色名称已存在");
        }
        existing.setName(role.getName());
        existing.setDescription(role.getDescription());
        return roleRepository.save(existing);
    }

    @Transactional
    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("角色不存在");
        }
        rolePermissionRepository.deleteByRoleId(id);
        roleRepository.deleteById(id);
    }
}
