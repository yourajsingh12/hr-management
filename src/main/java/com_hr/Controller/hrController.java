package com_hr.Controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com_hr.Entity.ComposeEntity;
import com_hr.Entity.CreatePost;
import com_hr.Entity.Employee;
import com_hr.Repository.ComposeReposetory;
import com_hr.Repository.CreatePostRepo;
import com_hr.Repository.Employee_Repository;
import com_hr.Service.Employee_Service;
import jakarta.servlet.http.HttpSession;

@Controller
public class hrController {

	@Autowired
	private Employee_Service employee_service;
	
	@Autowired
	private CreatePostRepo createPostRepo;
	
	@Autowired
	private Employee_Repository employeeRepo;
	
	@Autowired
	private ComposeReposetory composeRepo;
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/forget-password")
	public String forgetPassword()
	{
		return "forget-password";
	}
	
	//login form here
	@GetMapping("/home")
	public String home(@RequestParam("username") String username,@RequestParam("password") String password,Model model,HttpSession session)
	{
		System.out.println(username+" "+password);
		try {
			
			String empid=username.substring(3);
			System.out.println(empid);
			Employee employee=employeeRepo.findByIdAndPassword(Integer.parseInt(empid),password);//set password using id and date of birth
			
			if(employee!=null)
			{
				session.setAttribute("userId",Integer.parseInt(empid));//this session use for get id of user and show the data in my profile
				model.addAttribute("error",false);
				session.setAttribute("employee", employee);//this is use for dynamic username and degignation
				
				if(employee.getRole().equals("USER"))
				{

					return "redirect:/user-dashboard";
				}
				else if(employee.getRole().equals("ADMIN"))
				{
//					 this codes show the recent activity
					List<ComposeEntity>findAll=composeRepo.findAll();                  
					model.addAttribute("status",findAll);
					return"dash-board";
				}
				else
				{
					return "redirect:/login";
				}
				
				
			}
			else
			{
				model.addAttribute("error", true);
				return "redirect:/login";
			}
			
			
			
			
		}
		catch(NumberFormatException e)
		{
			
			System.err.println(e.getMessage());
			return"redirect:/login";
		}
		
			
		
	}
	
	@GetMapping("/dash-board")
	public String dashBoard()
	{
		
		return"dash-board";
	}
	
	@GetMapping("/add-employee")
	public String addEmployee()
	{
		return "add-employee";
	}
	
	@GetMapping("/all-employee")
	public String allEmployee(Model model)
	{
		List<Employee>allemployee=employee_service.getAllEmployee();
		model.addAttribute("allemployee", allemployee);
	return "all-employee";	
	}
	
	@GetMapping("/create-post")
	public String createPost(Model model)
	{
       List		<CreatePost> create=createPostRepo.findAll();
       model.addAttribute("post", create);
		return "create-post";
	}
	
	@GetMapping("/status")
	public String status(Model model)
	{
		List<ComposeEntity>findAll=composeRepo.findAll();
		model.addAttribute("status",findAll);
		return"status";
	}
	
	@GetMapping("/my-profile")
	public String myProfile(HttpSession session,Model model)
	{
		Object attribute=session.getAttribute("userId");
	   int 	userId=Integer.parseInt(attribute.toString());
	   Employee employee=employeeRepo.findById(userId).get();
	   model.addAttribute("employee", employee);
		System.out.println("id of my profile"+attribute);
		return"my-profile";
	}
	
	@GetMapping("/setting")
	public String setting()
	{
		return "setting";
	}
	
	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee)
	{
		employee.setPassword(employee.getDateOfBirth());  
       Employee	 save=employee_service.addEmployee(employee);
		return"redirect:/dash-board";
	}
	
	@PostMapping("/save-post")
	public String savePost(@ModelAttribute CreatePost createpost)
	{
		createpost.setAddedData(LocalDateTime.now().toString());
	   employee_service.addPost(createpost);
		return "redirect:/create-post";
	}
	
	@PostMapping("/update-password")
	public String updatePassword(@RequestParam("password") String password,@RequestParam("newPassword1")String newPassword1,@RequestParam("newPassword2")String newPassword2,HttpSession session,Model model)
	{
		System.out.println(password+""+newPassword1+" "+newPassword2);
	   Object	attribute=session.getAttribute("userId");
	   System.out.println(attribute);
	   int userId=Integer.parseInt(attribute.toString());
	   Employee employee=employeeRepo.findByIdAndPassword(userId, password);//password right or wrong 
	   
		if(employee !=null &&  newPassword1.equals(newPassword2))
		{
			employee.setPassword(newPassword2);
			employeeRepo.save(employee);
			model.addAttribute("error",false);
			return "redirect:/login";
		}
		else
		{
			model.addAttribute("error", true);
			return "setting";
		}
	}
	
	@GetMapping("/edit-record")
	public String editRecord(@RequestParam("id") int id,Model model)
	{
		Employee employee=employeeRepo.findById(id).get();
		model.addAttribute("employee", employee);
		
		return "edit-record";
	}
	
	@PostMapping("/edit-employee")
	public String updateRecord(@ModelAttribute Employee employee)
	{
		int id=employee.getId();
		 Employee EmpId=employeeRepo.findById(id).get();
		 if(EmpId !=null)
		 {
			 employeeRepo.save(employee);
			 return "redirect:/all-employee";
		 }
		
		return "redirect:/all-employee";
		
	}
	@GetMapping("/delete-record")
	public String deleteRecord(@RequestParam("id") int id)
	{
		employeeRepo.deleteById(id);
		return "redirect:/all-employee";
	}
	
	@GetMapping("/user-dashboard")
	public String userDashboard(Model model, HttpSession session)
	{
	  Object attibute=session.getAttribute("userId");
	 int userId=Integer.parseInt(attibute.toString());
	 
		List<ComposeEntity>findAll=composeRepo.findByParentUkid(userId);
		model.addAttribute("status",findAll);
	
		
		return "user-dashboard";
	}
	
	@GetMapping("/user-profile")
	public String userProfile(HttpSession session,Model model)
	{
		Object attribute=session.getAttribute("userId");
	   int 	userId=Integer.parseInt(attribute.toString());
	   Employee employee=employeeRepo.findById(userId).get();
	   model.addAttribute("employee", employee);
		System.out.println("id of my profile"+attribute);
		return"user-profile";
	}
	
	@GetMapping("/user-setting")
	public String userSetting()
	{
		return "user-setting";
	}
	
	@GetMapping("/user-compose")
	public String userCompose()
	{
		return"user-compose";
	}
	
	@PostMapping("/compose")
	public String adCompose(@RequestParam("subject")String subject,@RequestParam("text")String text,HttpSession session)
	{
	   try {
		   Object	attribute=session.getAttribute("userId");
		   int userId=Integer.parseInt(attribute.toString());
		   Employee employee=employeeRepo.findById(userId).get();
		   ComposeEntity compose=new ComposeEntity();
		   compose.setEmpName(employee.getEmployeeName());
		   compose.setSubject(subject);
		   compose.setText(text);
		   compose.setParentUkid(userId);
		   compose.setAddedDate(new Date().toString());
		   compose.setStatus("Pendding");
		    
		  ComposeEntity save=composeRepo.save(compose);
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return "redirect:/user-compose";
	}
}
