package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.student.management.model.StudentProfile;
import com.student.management.service.StudentProfileService;

@RestController
@RequestMapping("/api/student-profile")
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @GetMapping("/{studentId}")
    @PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_STAFF')")
    public ResponseEntity<StudentProfile> getStudentProfile(@PathVariable String studentId) {
        StudentProfile studentProfile = studentProfileService.getStudentProfile(studentId);
        if (studentProfile != null) {
            return ResponseEntity.ok(studentProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{studentId}")
    @PreAuthorize("hasRole('ROLE_STAFF')")
    public ResponseEntity<String> updateStudentProfile(@PathVariable String studentId, @RequestBody StudentProfile studentProfile) {
        studentProfileService.updateStudentProfile(studentId, studentProfile);
        return ResponseEntity.ok("Student profile updated successfully.");
    }
}
