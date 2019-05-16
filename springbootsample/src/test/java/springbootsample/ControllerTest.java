package springbootsample;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.application.AppController;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
    	Integer empID = 100102;
    	Employee emp = new Employee();
    	emp.setEmpID(empID);
    	emp.setName("jill");
    	emp.setEmail("jill@infy.com");
        when(service.getEmployee(empID)).thenReturn(emp);
        this.mockMvc.perform(get("/getEmployee/" + empID.toString())).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("jill@infy.com")))
                .andExpect(content().string(containsString("jill")))
                .andExpect(content().string(containsString("100102")));
    }
}