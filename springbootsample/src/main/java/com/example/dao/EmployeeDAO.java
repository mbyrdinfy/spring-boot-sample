package com.example.dao;

import com.example.model.Employee;

public interface EmployeeDAO {

	public Integer createEmployee(Employee emp);
	public Employee getEmployee(Integer empID);
	public Integer updateEmployee(Employee emp);
	public String deleteEmployee(Integer empID);

}
