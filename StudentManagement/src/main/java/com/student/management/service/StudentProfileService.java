package com.student.management.service;

import com.student.management.model.StudentProfile;

public interface StudentProfileService {

	StudentProfile getStudentProfile(String studentId);

	void updateStudentProfile(String studentId, StudentProfile studentProfile);

}
