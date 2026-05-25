package com.usermanagement.controller;

import com.usermanagement.dto.ApiResponse;
import com.usermanagement.entity.OperationLog;
import com.usermanagement.service.OperationLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OperationLogController {

    private final OperationLogService operationLogService;

    @GetMapping
    public ApiResponse<Page<OperationLog>> searchLogs(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String operation,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<OperationLog> logs = operationLogService.searchLogs(userId, operation, startTime, endTime, pageable);
        return ApiResponse.success(logs);
    }

    @GetMapping("/{id}")
    public ApiResponse<OperationLog> getLogById(@PathVariable Long id) {
        OperationLog log = operationLogService.getLogById(id);
        return ApiResponse.success(log);
    }
}
