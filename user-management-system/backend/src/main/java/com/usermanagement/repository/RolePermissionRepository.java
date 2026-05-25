package com.usermanagement.repository;

import com.usermanagement.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermission.RolePermissionId> {

    @Query("SELECT rp FROM RolePermission rp WHERE rp.id.roleId = :roleId")
    List<RolePermission> findByRoleId(@Param("roleId") Long roleId);

    @Query("SELECT rp FROM RolePermission rp WHERE rp.id.permissionId = :permissionId")
    List<RolePermission> findByPermissionId(@Param("permissionId") Long permissionId);

    @Query("DELETE FROM RolePermission rp WHERE rp.id.roleId = :roleId")
    void deleteByRoleId(@Param("roleId") Long roleId);

    @Query("DELETE FROM RolePermission rp WHERE rp.id.permissionId = :permissionId")
    void deleteByPermissionId(@Param("permissionId") Long permissionId);
}
