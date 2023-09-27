package com.student.management.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.interceptors.EntityNotFoundException;
import com.student.management.model.StudentProfile;
import com.student.management.repository.StudentProfileRepository;
import com.student.management.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

	@Autowired
	private StudentProfileRepository studentProfileRepository;

	public StudentProfile getStudentProfile(String studentId) {
		return studentProfileRepository.findByStudentId(studentId);
	}

	public void updateStudentProfile(String studentId, StudentProfile studentProfile) {
		StudentProfile existingProfile = studentProfileRepository.findByStudentId(studentId);
		if (existingProfile != null) {
			// Update student profile
			studentProfileRepository.save(studentProfile);
		} else {
			throw new EntityNotFoundException("Student profile not found");
		}
	}

}
