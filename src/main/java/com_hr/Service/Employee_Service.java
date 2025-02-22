package com_hr.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com_hr.Entity.CreatePost;
import com_hr.Entity.Employee;
import com_hr.Repository.CreatePostRepo;
import com_hr.Repository.Employee_Repository;

@Service
public class Employee_Service {

	@Autowired
	private Employee_Repository employee_Repo;
	
	@Autowired
	private CreatePostRepo createPostRepo;
	
	public Employee addEmployee(Employee employee)
	{
		Employee save=employee_Repo.save(employee);
		return save;
	}
	
	public List<Employee> getAllEmployee()
	{
		List<Employee>findAll=employee_Repo.findAll();
		return findAll;
	}
	
	public CreatePost addPost(CreatePost createpost)
	{
	CreatePost	add=createPostRepo.save(createpost);
		return add;
		
	}
}
