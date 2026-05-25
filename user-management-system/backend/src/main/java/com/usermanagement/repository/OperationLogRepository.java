package com.usermanagement.repository;

import com.usermanagement.entity.OperationLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OperationLogRepository extends JpaRepository<OperationLog, Long> {

    List<OperationLog> findByUserIdOrderByCreatedAtDesc(Long userId);

    Page<OperationLog> findByOperationOrderByCreatedAtDesc(String operation, Pageable pageable);

    @Query("SELECT ol FROM OperationLog ol WHERE " +
           "(:userId IS NULL OR ol.userId = :userId) AND " +
           "(:operation IS NULL OR ol.operation = :operation) AND " +
           "(:startTime IS NULL OR ol.createdAt >= :startTime) AND " +
           "(:endTime IS NULL OR ol.createdAt <= :endTime)")
    Page<OperationLog> searchLogs(@Param("userId") Long userId,
                                  @Param("operation") String operation,
                                  @Param("startTime") LocalDateTime startTime,
                                  @Param("endTime") LocalDateTime endTime,
                                  Pageable pageable);
}
