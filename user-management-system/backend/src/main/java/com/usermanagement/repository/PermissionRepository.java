package com.usermanagement.repository;

import com.usermanagement.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query("SELECT DISTINCT p FROM Permission p " +
           "INNER JOIN RolePermission rp ON rp.id.permissionId = p.id " +
           "INNER JOIN UserRole ur ON ur.id.roleId = rp.id.roleId " +
           "WHERE ur.id.userId = :userId")
    List<Permission> findByUserId(@Param("userId") Long userId);

    @Query("SELECT p FROM Permission p " +
           "INNER JOIN RolePermission rp ON rp.id.permissionId = p.id " +
           "WHERE rp.id.roleId = :roleId")
    List<Permission> findByRoleId(@Param("roleId") Long roleId);
}
