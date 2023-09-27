package com.student.management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String staffName;
    private String staffId;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

	public Staff() {
		super();
	}

	public Staff(Long id, String staffName, String staffId, Department department) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.staffId = staffId;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", staffName=" + staffName + ", staffId=" + staffId + ", department=" + department
				+ "]";
	}
    
}
