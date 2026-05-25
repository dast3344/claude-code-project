package com.usermanagement.dto;

import com.usermanagement.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String phone;
    private String fullName;
    private String avatar;
    private String bio;
    private Long departmentId;
    private String status;
    private LocalDateTime lastLoginTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> roles;

    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setFullName(user.getFullName());
        dto.setAvatar(user.getAvatar());
        dto.setBio(user.getBio());
        dto.setDepartmentId(user.getDepartmentId());
        dto.setStatus(user.getStatus() != null ? user.getStatus().name() : null);
        dto.setLastLoginTime(user.getLastLoginTime());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
    }
}
