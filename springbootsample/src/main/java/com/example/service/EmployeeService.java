package com.example.service;

import com.example.model.Employee;

public interface EmployeeService {

	public Integer createEmployee(Employee emp);
	
	public Employee getEmployee(Integer empID);
	
	public Integer updateEmployee(Employee emp); 
	
	public String deleteEmployee(Integer empID);
}
