package com.student.management.service;

import com.student.management.model.Department;

public interface DepartmentService {

	boolean departmentExists(String name);

	void addDepartment(Department department);

}
