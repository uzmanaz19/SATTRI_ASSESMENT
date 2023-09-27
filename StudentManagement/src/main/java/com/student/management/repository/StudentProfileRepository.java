package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.model.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

	StudentProfile findByStudentId(String studentId);

}
