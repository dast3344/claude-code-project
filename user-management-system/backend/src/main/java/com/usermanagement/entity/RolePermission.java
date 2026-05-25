package com.usermanagement.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "role_permissions")
@Data
public class RolePermission {

    @EmbeddedId
    private RolePermissionId id;

    @Column(name = "created_at", updatable = false)
    private java.time.LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
    }

    @Embeddable
    @Data
    public static class RolePermissionId implements java.io.Serializable {
        @Column(name = "role_id", nullable = false)
        private Long roleId;

        @Column(name = "permission_id", nullable = false)
        private Long permissionId;
    }
}
