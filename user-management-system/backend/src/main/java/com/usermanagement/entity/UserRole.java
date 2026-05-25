package com.usermanagement.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_roles")
@Data
public class UserRole {

    @EmbeddedId
    private UserRoleId id;

    @Column(name = "created_at", updatable = false)
    private java.time.LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
    }

    @Embeddable
    @Data
    public static class UserRoleId implements java.io.Serializable {
        @Column(name = "user_id", nullable = false)
        private Long userId;

        @Column(name = "role_id", nullable = false)
        private Long roleId;
    }
}
