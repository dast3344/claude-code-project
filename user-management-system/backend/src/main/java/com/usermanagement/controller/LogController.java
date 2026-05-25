package com.usermanagement.controller;

import com.usermanagement.dto.ApiResponse;
import com.usermanagement.dto.PageResponse;
import com.usermanagement.entity.OperationLog;
import com.usermanagement.service.OperationLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LogController {

    private final OperationLogService logService;

    @GetMapping
    public ApiResponse<PageResponse<OperationLog>> getLogs(
            @RequestParam(required = false) String operation,
            @RequestParam(required = false) Long userId,
            Pageable pageable) {
        Page<OperationLog> logs;
        if (operation != null || userId != null) {
            logs = logService.searchLogs(userId, operation, null, null, pageable);
        } else {
            logs = logService.getAllLogs(pageable);
        }
        return ApiResponse.success(PageResponse.of(logs));
    }

    @GetMapping("/{id}")
    public ApiResponse<OperationLog> getLogById(@PathVariable Long id) {
        OperationLog log = logService.getLogById(id);
        return ApiResponse.success(log);
    }
}
