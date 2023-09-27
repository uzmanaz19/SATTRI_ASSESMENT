package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.student.management.model.Staff;
import com.student.management.service.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_PRINCIPAL', 'ROLE_HOD')")
    public ResponseEntity<String> addStaff(@RequestBody Staff staff) {
        staffService.addStaff(staff);
        return ResponseEntity.ok("Staff member added successfully.");
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ROLE_PRINCIPAL', 'ROLE_HOD')")
    public ResponseEntity<String> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        staffService.updateStaff(id, staff);
        return ResponseEntity.ok("Staff member updated successfully.");
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_PRINCIPAL', 'ROLE_HOD')")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.ok("Staff member deleted successfully.");
    }
}
