package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

	@Id
	@Column
	private Integer empID;
	@Column
	private String name;
	@Column
	private String email;
		
	public Integer getID() {
		return empID;
	}
	public void setID(Integer empNumber) {
		this.empID = empNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
