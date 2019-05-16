package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

@Service(value = "EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	 @Autowired
	    private EmployeeDAO empDAO;
	
	public Integer createEmployee(Employee emp) {
		
		System.out.println(emp.getEmpID() + " " + emp.getName() + " " + emp.getEmail());
		Integer newEmp = empDAO.createEmployee(emp);
		return newEmp;
	}
	
	public Employee getEmployee(Integer empID) {
		
		Employee emp = empDAO.getEmployee(empID);
		return emp;
	}
	
	public Integer updateEmployee(Employee emp) {
		
		return empDAO.updateEmployee(emp);
	}
	
	public String deleteEmployee(Integer empID) {
		
		return empDAO.deleteEmployee(empID);
	}
}
