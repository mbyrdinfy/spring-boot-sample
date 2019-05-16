package springbootsample;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.dao.EmployeeDAOImpl;
import com.example.exception.InvalidInputDataException;
import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

	@Mock
	EmployeeDAOImpl dao;
	
	@InjectMocks
	EmployeeServiceImpl service;
	
	@Test
	public void getWithValidDataTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		when(dao.getEmployee(100102)).thenReturn(emp);
		assertEquals(emp, service.getEmployee(100102));
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void getWithInvalidDataTest() {
		service.getEmployee(100);
	}
	
	@Test
	public void createWithValidDataTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		when(dao.createEmployee(emp)).thenReturn(emp.getEmpID());
		assertEquals(emp.getEmpID(), service.createEmployee(emp));
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void createWithInvalidIDTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		service.createEmployee(emp);
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void createWithInvalidNameTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill245");
		emp.setEmail("jill@infy.com");
		service.createEmployee(emp);
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void createWithEmptyNameTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("");
		emp.setEmail("jill@infy.com");
		service.createEmployee(emp);
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void createWithEmptyEmailTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("");
		service.createEmployee(emp);
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void createWithInvalidEmailTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("jill@infy");
		service.createEmployee(emp);
	}
	
	@Test
	public void editWithValidDataTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		when(dao.updateEmployee(emp)).thenReturn(emp.getEmpID());
		assertEquals(emp.getEmpID(), service.updateEmployee(emp));
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void updateWithInvalidIDTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		service.updateEmployee(emp);
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void updateWithInvalidNameTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill254");
		emp.setEmail("jill@infy.com");
		service.updateEmployee(emp);
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void updateWithEmptyNameTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("");
		emp.setEmail("jill@infy.com");
		service.updateEmployee(emp);
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void updateWithInvalidEmailTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("jill@infy");
		service.updateEmployee(emp);
	}
	
	@Test
	public void deleteWithValidDataTest() {
		Integer empID = 100102;
		when(dao.deleteEmployee(empID)).thenReturn("deleted employee " + empID + " successfully!");
		assertEquals("deleted employee " + empID + " successfully!", service.deleteEmployee(empID));
	}
	
	@Test(expected = InvalidInputDataException.class)
	public void deleteWithInvalidIDTest() {
		Integer empID = 100;
		service.deleteEmployee(empID);
	}
	
}
