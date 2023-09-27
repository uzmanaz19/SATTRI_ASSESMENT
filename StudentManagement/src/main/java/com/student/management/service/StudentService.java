package com.student.management.service;

import com.student.management.model.Student;

public interface StudentService {

	void addStudent(Student student);

	void updateStudent(Long id, Student student);

	void deleteStudent(Long id);

}
