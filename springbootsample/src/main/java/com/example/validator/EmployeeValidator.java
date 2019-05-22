package com.example.validator;

import org.springframework.stereotype.Component;

import com.example.exception.InvalidInputDataException;
import com.example.model.Employee;

@Component
public class EmployeeValidator{

	public void validateEmployeeObj(Employee emp) throws InvalidInputDataException {
		if(!this.validateID(emp.getEmpID())) {
			throw new InvalidInputDataException("Invalid Employee ID");
		}
		if(!this.validateName(emp.getName()))
			throw new InvalidInputDataException("Invalid Employee Name");
		if(!this.validateEmail(emp.getEmail()))
			throw new InvalidInputDataException("Invalid Employee Email");
	}
	
	public void validateEmployeeID(Integer empID) throws InvalidInputDataException{
		if(!this.validateID(empID)) {
			throw new InvalidInputDataException("Invalid Employee ID given");
		}
	}
	
	private boolean validateID(Integer empID) {
		return (empID.toString().length() == 6);
	}
	
	private boolean validateName(String empName) {
		return (empName.matches("[^ ][A-Za-z ]+[^ ]"));
	}
	
	private boolean validateEmail(String empEmail) {
		return (empEmail.matches("[a-zA-Z0-9]+@[a-zA-Z]{2,}\\.[A-Za-z]+[a-zA-Z\\.]+"));
	}
}
