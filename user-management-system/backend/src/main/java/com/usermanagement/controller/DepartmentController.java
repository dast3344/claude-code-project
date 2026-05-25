package com.usermanagement.controller;

import com.usermanagement.dto.ApiResponse;
import com.usermanagement.entity.Department;
import com.usermanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ApiResponse<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ApiResponse.success(departments);
    }

    @GetMapping("/tree")
    public ApiResponse<List<Department>> getDepartmentTree(@RequestParam(required = false) Long parentId) {
        List<Department> departments = departmentService.getDepartmentsByParentId(parentId);
        return ApiResponse.success(departments);
    }

    @GetMapping("/{id}")
    public ApiResponse<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id);
        return ApiResponse.success(department);
    }

    @PostMapping
    public ApiResponse<Department> createDepartment(@RequestBody Department department) {
        Department created = departmentService.createDepartment(department);
        return ApiResponse.success("部门创建成功", created);
    }

    @PutMapping("/{id}")
    public ApiResponse<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        Department updated = departmentService.updateDepartment(id, department);
        return ApiResponse.success("部门更新成功", updated);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ApiResponse.success("部门删除成功", null);
    }
}
