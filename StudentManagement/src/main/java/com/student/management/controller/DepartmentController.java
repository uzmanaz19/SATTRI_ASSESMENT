package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.student.management.model.Department;
import com.student.management.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_PRINCIPAL')")
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        if (departmentService.departmentExists(department.getName())) {
            return ResponseEntity.badRequest().body("Department already exists.");
        }

        departmentService.addDepartment(department);
        return ResponseEntity.ok("Department added successfully.");
    }
}
