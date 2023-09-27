package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.model.Student;
import com.student.management.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
    private StudentService studentService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_STAFF')")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok("Student added successfully.");
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_STAFF')")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok("Student updated successfully.");
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_STAFF')")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully.");
    }

}
