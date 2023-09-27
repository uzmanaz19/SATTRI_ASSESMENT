package com.student.management.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.management.model.Department;
import com.student.management.repository.DepartmentRepository;
import com.student.management.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
    private DepartmentRepository departmentRepository;

	@Override
	public boolean departmentExists(String departmentName) {
		return departmentRepository.existsByName(departmentName);
	}

	@Override
	public void addDepartment(Department department) {
		departmentRepository.save(department);
	}

}
