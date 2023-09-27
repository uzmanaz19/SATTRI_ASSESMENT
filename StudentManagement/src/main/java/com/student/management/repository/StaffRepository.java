package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{

}
