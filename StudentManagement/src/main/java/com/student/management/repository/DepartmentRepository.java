package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.model.*;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	boolean existsByName(String departmentName);

}
