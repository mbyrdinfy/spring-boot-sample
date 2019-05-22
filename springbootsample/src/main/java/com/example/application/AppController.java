package com.example.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;
import com.example.utility.ContextFactory;

@RestController
public class AppController {
	
	EmployeeService employeeService = (EmployeeService) ContextFactory.getContext().getBean(EmployeeServiceImpl.class);

	@RequestMapping(value = "/newEmployee", method= RequestMethod.PUT)
	public ResponseEntity<Integer> createEmp(@RequestBody Employee emp) {
		Integer setEmpID = 0;
		try {
		setEmpID = employeeService.createEmployee(emp);
		return new ResponseEntity<Integer>(setEmpID, HttpStatus.OK);
		
		} catch(Exception e) {
			return new ResponseEntity<Integer>(setEmpID, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getEmployee/{empID}", method= RequestMethod.GET)
	public ResponseEntity<Employee> getEmp(@PathVariable Integer empID) {
		Employee emp = new Employee();
		
		try {
		emp = employeeService.getEmployee(empID);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} catch(Exception e) {
			System.out.println(e.getMessage() + e.getClass());
			return new ResponseEntity<Employee>(emp, HttpStatus.BAD_REQUEST);
		}
	}

	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ResponseEntity<Integer> updateEmp(@RequestBody Employee emp){
		Integer setEmpID = 0;
		
		try {
		setEmpID = employeeService.updateEmployee(emp);
		return new ResponseEntity<Integer>(setEmpID, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Integer>(setEmpID, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/deleteEmployee/{empID}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmp(@PathVariable Integer empID){
		String deleteResponse = "delete failed";
		
		try {
		deleteResponse = employeeService.deleteEmployee(empID);
		return new ResponseEntity<String>(deleteResponse, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(deleteResponse, HttpStatus.BAD_REQUEST);
		}
	}
	

	@RequestMapping(value = "/getTest", method= RequestMethod.GET)
	public ResponseEntity<String> testGet() {
		return new ResponseEntity<String>("Success!", HttpStatus.OK);
	}
		
	
}
