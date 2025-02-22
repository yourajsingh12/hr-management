package com_hr.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com_hr.Controller.hrController;
import com_hr.Entity.Employee;
import com_hr.Repository.ComposeReposetory;
import com_hr.Repository.CreatePostRepo;
import com_hr.Repository.Employee_Repository;
import com_hr.Service.Employee_Service;

@WebMvcTest(hrController.class)
public class TestHr_Controller {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Employee_Service service;

    @MockBean
    private CreatePostRepo createPostRepo;

    @MockBean
    private Employee_Repository employeeRepo;

    @MockBean
    private ComposeReposetory composeRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHome_UserRedirect() throws Exception {
        // Create mock Employee
        Employee employee = new Employee();
        employee.setId(101);
        employee.setEmployeeName("Yuvraj Singh");
        employee.setEmail("singhrajputyuvraj34@gmail.com");
        employee.setAadhaarNo("74755858");
        employee.setRole("USER");

        // Mock repository method to return this employee
        when(employeeRepo.findByIdAndPassword(101, "12345")).thenReturn(employee);

        // Perform GET request and verify redirection
        mockMvc.perform(get("/home")
                .param("username", "emp101")  // Ensure username matches expected format
                .param("password", "12345"))
                .andExpect(status().is3xxRedirection())  // Expect redirect status
                .andExpect(redirectedUrl("/user-dashboard"));  // Verify correct redirection
    }

//    @Test
//    void testHome_AdminRedirect() throws Exception {
//        Employee admin = new Employee();
//        admin.setId(102);
//        admin.setEmployeeName("Admin User");
//        admin.setEmail("admin@example.com");
//        admin.setAadhaarNo("12345678");
//        admin.setRole("ADMIN");
//
//        when(employeeRepo.findByIdAndPassword(102, "adminPass")).thenReturn(admin);
//
//        mockMvc.perform(get("/home")
//                .param("username", "emp102")
//                .param("password", "adminPass"))
//                .andExpect(status().isOk())  // Expecting a page load, not redirect
//                .andExpect(redirectedUrl("dash-board"));
//    }

    @Test
    public void testSavePost() throws Exception
    {
    	mockMvc.perform(post("/save-post")
    	.param("title", "new tiitlw")
    	.param("comment","this is comment")
    			)
    	.andExpect(status().is3xxRedirection())
    	.andExpect(redirectedUrl("/create-post"));
    }
}
