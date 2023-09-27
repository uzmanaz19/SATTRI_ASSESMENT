package com.student.management.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.student.management.interceptors.EntityNotFoundException;
import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        // Add student record
        studentRepository.save(student);
    }

    public void updateStudent(Long id, Student student) {
        // Find student record by ID
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        // Update student record
        studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        // Delete student record by ID
        studentRepository.deleteById(id);
    }
}
