package springbootsample;

import static org.hamcrest.Matchers.containsString;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.App;
import com.example.application.AppController;
import com.example.configuration.SpringConfig;
import com.example.model.Employee;
import com.example.service.EmployeeService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = AppController.class, secure = false)
@ContextConfiguration(classes=SpringConfig.class)
//@SpringBootTest(classes = AppController.class)
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;
    
    @Before
    public void setUp() {
      mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
//    @Test
//    public void greetingShouldReturnDefaultMessage() throws Exception {
//    	Integer empID = 100102;
//    	Employee emp = new Employee();
//    	emp.setEmpID(empID);
//    	emp.setName("jill");
//    	emp.setEmail("jill@infy.com");
//    	when(service.getEmployee(empID)).thenReturn(emp);
//    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"/getEmployee/" + empID).accept(
//				MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		System.out.println(result.getResponse());
//		String expected = "{\r\n" + 
//				" \"empID\":\"100102\",\r\n" + 
//				" \"email\":\"jillian@infy.com\",\r\n" + 
//				" \"name\":\"jill\"\r\n" + 
//				"}";
//
//		Assert.assertEquals(200, result.getResponse().getStatus());
////		JSONAssert.assertEquals(expected, result.getResponse()
////				.getContentAsString(), false);
//    }
    
    @Test
    public void testGetTest() throws Exception {
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getTest").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		

		Assert.assertEquals(200, result.getResponse().getStatus());
//		JSONAssert.assertEquals(expected, result.getResponse()
//				.getContentAsString(), false);
    }


}