package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;
import com.example.validator.EmployeeValidator;

@Service(value = "EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	 @Autowired
	    private EmployeeDAO empDAO;
	 
	 @Autowired
	 	private EmployeeValidator validator;
	
	public Integer createEmployee(Employee emp) throws Exception {
		validator.validateEmployeeObj(emp);
		Integer newEmp = empDAO.createEmployee(emp);
		return newEmp;
	}
	
	public Employee getEmployee(Integer empID) throws Exception {
		validator.validateEmployeeID(empID);
		Employee emp = empDAO.getEmployee(empID);
		return emp;
	}
	
	public Integer updateEmployee(Employee emp) throws Exception {
		validator.validateEmployeeObj(emp);
		return empDAO.updateEmployee(emp);
	}
	public String deleteEmployee(Integer empID) throws Exception {
		validator.validateEmployeeID(empID);
		return empDAO.deleteEmployee(empID);
	}
}
