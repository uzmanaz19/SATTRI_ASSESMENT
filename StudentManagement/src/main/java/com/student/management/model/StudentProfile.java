package com.student.management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String studentId;
    private String firstName;
    private String lastName;
    
    @OneToOne
    private Student student;

	public StudentProfile() {
		super();
	}

	public StudentProfile(Long id, String studentId, String firstName, String lastName, Student student) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentProfile [id=" + id + ", studentId=" + studentId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", student=" + student + "]";
	}
    
}
