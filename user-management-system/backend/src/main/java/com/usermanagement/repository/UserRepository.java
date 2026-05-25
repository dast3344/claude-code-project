package com.usermanagement.repository;

import com.usermanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<User> findByDepartmentId(Long departmentId);

    Page<User> findByStatus(User.UserStatus status, Pageable pageable);

    @Query("SELECT u FROM User u WHERE " +
           "(:keyword IS NULL OR :keyword = '' OR " +
           "u.username LIKE %:keyword% OR " +
           "u.email LIKE %:keyword% OR " +
           "u.fullName LIKE %:keyword% OR " +
           "u.phone LIKE %:keyword%) AND " +
           "(:status IS NULL OR u.status = :status) AND " +
           "(:departmentId IS NULL OR u.departmentId = :departmentId)")
    Page<User> searchUsers(@Param("keyword") String keyword,
                          @Param("status") User.UserStatus status,
                          @Param("departmentId") Long departmentId,
                          Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.id IN (" +
           "SELECT ur.id.userId FROM UserRole ur WHERE ur.id.roleId = :roleId)")
    List<User> findByRoleId(@Param("roleId") Long roleId);
}
