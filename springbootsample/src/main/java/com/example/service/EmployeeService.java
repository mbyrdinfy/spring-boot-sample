package com.example.service;

import com.example.model.Employee;

public interface EmployeeService {

	public Integer createEmployee(Employee emp) throws Exception;
	
	public Employee getEmployee(Integer empID) throws Exception;
	
	public Integer updateEmployee(Employee emp) throws Exception; 
	
	public String deleteEmployee(Integer empID) throws Exception;
}
