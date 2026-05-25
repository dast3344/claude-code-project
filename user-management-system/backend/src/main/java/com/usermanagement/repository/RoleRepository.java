package com.usermanagement.repository;

import com.usermanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

    boolean existsByName(String name);

    @Query("SELECT DISTINCT r FROM Role r " +
           "INNER JOIN UserRole ur ON ur.id.roleId = r.id " +
           "WHERE ur.id.userId = :userId")
    List<Role> findByUserId(@Param("userId") Long userId);
}
