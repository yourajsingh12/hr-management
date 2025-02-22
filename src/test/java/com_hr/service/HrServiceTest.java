package com_hr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com_hr.Entity.CreatePost;
import com_hr.Entity.Employee;
import com_hr.Repository.CreatePostRepo;
import com_hr.Repository.Employee_Repository;
import com_hr.Service.Employee_Service;

public class HrServiceTest {

	@Mock
	private Employee_Repository employeeRepo;
	
	@Mock
	private CreatePostRepo createRepo;
	
	@InjectMocks
	private Employee_Service employeeService;
	
	
	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test	
	void testAddEmployee()
	{
		Employee employee=new Employee();
		employee.setId(1);
		employee.setEmployeeName("yuvaj");
		employee.setEmail("singhrajputyuvraj34@gmail.com");
		when(employeeRepo.save(employee)).thenReturn(employee);
	   Employee	addEmployee=employeeService.addEmployee(employee);
	   verify(employeeRepo).save(employee);
	   assertEquals(employee,addEmployee);
	}
	
	@Test
	void testgetAllEmployee()
	{
		List<Employee>employeeList=new ArrayList<>();
		Employee employee=new Employee();
		employee.setId(1);
		employee.setEmployeeName("yuvraj");
		employee.setEmail("singhrajputyuvraj@gmail.com");
		
	   Employee	employee2=new Employee();
	   employee2.setId(2);
	   employee2.setEmployeeName("singh");
	   employee2.setEmail("kingsingh34@gmail.com");
	   employeeList.add(employee);
	   employeeList.add(employee2);
	   
	   when(employeeRepo.findAll()).thenReturn(employeeList); //mocking
	   
	   List<Employee>result=employeeService.getAllEmployee();//testing k liye getEmployeeService ka method hai
	    assertEquals(employeeList,result);
	}
	
	     @Test
	     void testaddPost()
	     {
	    	 CreatePost postEmployee=new CreatePost();
	    	 postEmployee.setId(1);
	    	 postEmployee.setTitle("bimar hu");
	    	 postEmployee.setComment("nhi aaunga");
	    	 
	    	 when(createRepo.save(postEmployee)).thenReturn(postEmployee);
	    	CreatePost addpost=employeeService.addPost(postEmployee);
	    	verify(createRepo).save(postEmployee);
	    	assertEquals(postEmployee,addpost);
	    	 
	     }
	
	
}
