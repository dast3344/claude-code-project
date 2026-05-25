package com.usermanagement.service;

import com.usermanagement.entity.OperationLog;
import com.usermanagement.repository.OperationLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OperationLogService {

    private final OperationLogRepository operationLogRepository;

    public Page<OperationLog> searchLogs(Long userId, String operation, LocalDateTime startTime, LocalDateTime endTime, Pageable pageable) {
        return operationLogRepository.searchLogs(userId, operation, startTime, endTime, pageable);
    }

    public Page<OperationLog> getAllLogs(Pageable pageable) {
        return operationLogRepository.findAll(pageable);
    }

    public OperationLog getLogById(Long id) {
        return operationLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("日志不存在"));
    }
}
