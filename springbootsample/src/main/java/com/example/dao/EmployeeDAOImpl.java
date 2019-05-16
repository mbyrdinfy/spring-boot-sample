package com.example.dao;

import org.springframework.transaction.annotation.Transactional; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.EmployeeEntity;
import com.example.model.Employee;

@Repository(value = "EmployeeDAO")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Employee getEmployee(Integer empID) {
		Session session = sessionFactory.getCurrentSession();
		EmployeeEntity ee = session.get(EmployeeEntity.class, empID);
		
		Employee newEmp = new Employee();
		
		newEmp.setEmpID(ee.getID());
		newEmp.setName(ee.getName());
		newEmp.setEmail(ee.getEmail());
		
		return newEmp;
	}
	
	public Integer createEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		EmployeeEntity newEmployee = new EmployeeEntity();
		
		newEmployee.setID(emp.getEmpID());
		newEmployee.setName(emp.getName());
		newEmployee.setEmail(emp.getEmail());
		
		return (Integer) session.save(newEmployee);
	}
	
	public Integer updateEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		EmployeeEntity ee = session.get(EmployeeEntity.class, emp.getEmpID());
		
		if(emp.getName() != null)
			ee.setName(emp.getName());
		if(emp.getEmail() != null)
			ee.setEmail(emp.getEmail());
		
		return (Integer) session.save(ee);
	}
	
	public String deleteEmployee(Integer empID) {
		Session session = sessionFactory.getCurrentSession();
			
			EmployeeEntity empToRemove = (EmployeeEntity)session.load(EmployeeEntity.class,empID);
			
			try {
			    session.delete(empToRemove);
			    session.flush();
			    return "deleted employee " + empID + " successfully!";
			} catch(Exception e) {
				return "could not delete employee with ID: " + empID;
			}
   

	}
	
		
}
