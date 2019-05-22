package springbootsample;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
	
	@Mock
	EmployeeServiceImpl service;
	
	@Test
	public void getWithValidDataTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		when(dao.getEmployee(100102)).thenReturn(emp);
		try {
			
		Employee serviceReturn = service.getEmployee(100102);
		assertEquals(emp, serviceReturn);
		}catch(Exception e) {
			Assert.fail();
		}
		
	}
	
	@Test
	public void getWithInvalidDataTest() {
		try {
		service.getEmployee(100);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void createWithValidDataTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		when(dao.createEmployee(emp)).thenReturn(emp.getEmpID());
		try {
		assertEquals(emp.getEmpID(), service.createEmployee(emp));
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void createWithInvalidIDTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		try {
		service.createEmployee(emp);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void createWithInvalidNameTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill245");
		emp.setEmail("jill@infy.com");
		try {
		service.createEmployee(emp);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void createWithEmptyNameTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("");
		emp.setEmail("jill@infy.com");
		try {
		service.createEmployee(emp);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void createWithEmptyEmailTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("");
		try {
		service.createEmployee(emp);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void createWithInvalidEmailTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("jill@infy");
		try {
		service.createEmployee(emp);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void editWithValidDataTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		when(dao.updateEmployee(emp)).thenReturn(emp.getEmpID());
		try {
			System.out.println(service.updateEmployee(emp));
		assertEquals(emp.getEmpID(), service.updateEmployee(emp));
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void updateWithInvalidIDTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("jill@infy.com");
		try {
		service.updateEmployee(emp);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void updateWithInvalidNameTest() {
		Employee emp = new Employee();
		emp.setEmpID(100102);
		emp.setName("jill254");
		emp.setEmail("jill@infy.com");
		try {
		service.updateEmployee(emp);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void updateWithEmptyNameTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("");
		emp.setEmail("jill@infy.com");
		try {
		service.updateEmployee(emp);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void updateWithInvalidEmailTest() {
		Employee emp = new Employee();
		emp.setEmpID(100);
		emp.setName("jill");
		emp.setEmail("jill@infy");
		try {
		service.updateEmployee(emp);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
	@Test
	public void deleteWithValidDataTest() {
		Integer empID = 100102;
		when(dao.deleteEmployee(empID)).thenReturn("deleted employee " + empID + " successfully!");
		try {
		assertEquals("deleted employee " + empID + " successfully!", service.deleteEmployee(empID));
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void deleteWithInvalidIDTest() {
		Integer empID = 100;
		try {
		service.deleteEmployee(empID);
		Assert.fail();
		}catch(InvalidInputDataException e) {
		}catch(Exception e) {
			System.out.println(e.getClass());
			Assert.fail();
		}
	}
	
}
