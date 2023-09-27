package com.student.management.service;

import com.student.management.model.Staff;

public interface StaffService {

	void addStaff(Staff staff);

	void updateStaff(Long id, Staff staff);

	void deleteStaff(Long id);

}
