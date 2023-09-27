package com.student.management.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.interceptors.EntityNotFoundException;
import com.student.management.model.Staff;
import com.student.management.repository.StaffRepository;
import com.student.management.service.StaffService;

@Service
public class StaffServiceImpl implements  StaffService{

	@Autowired
    private StaffRepository staffRepository;

    public void addStaff(Staff staff) {
        // Add staff member
        staffRepository.save(staff);
    }

    public void updateStaff(Long id, Staff staff) {
        // Find staff member by ID
        Staff existingStaff = staffRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Staff member not found"));
        // Update staff member
        staffRepository.save(existingStaff);
    }

    public void deleteStaff(Long id) {
        // Delete staff member by ID
        staffRepository.deleteById(id);
    }
    
}
