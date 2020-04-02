package com.c2p.producer;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.c2p.domain.Employee;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CustomerAccountTestCase {

	@InjectMocks
	CustomerAccountController employeeController;
	
     
    @Test
    public void testFindAllAccounts() 
    {
        // given
    	Account acnt4=new Account("Marry",5000.00,"newyork","2019-05-03");
		Account acnt5=new Account("Nihar",6000.00,"mumbai","2019-06-04");
		Account acnt6=new Account("Maher",8000.00,"delhi","2019-07-04");
        employees.setEmployeeList(Arrays.asList(acnt4, acnt5));
 
        when(employeeDAO.getAllAccount()).thenReturn(acnt6);
 
        // when
        Employees result = employeeController.getEmployees();
 
        // then
        assertThat(result.getEmployeeList().size()).isEqualTo(2);
         
        assertThat(result.getEmployeeList().get(0).getFirstName())
                        .isEqualTo(employee1.getFirstName());
         
        assertThat(result.getEmployeeList().get(1).getFirstName())
                        .isEqualTo(employee2.getFirstName());
    }

	@Test
    public void testgetTransaction() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        when(employeeDAO.addEmployee(any(Employee.class))).thenReturn(true);
         
        Account acnt1=new Account("Alok",2000.00,"bangalore","2019-02-04");
        ResponseEntity<Object> responseEntity = employeeController.addEmployee(acnt1);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
}
