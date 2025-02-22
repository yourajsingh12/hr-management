package com_hr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com_hr.Entity.Employee;

@Repository
public interface Employee_Repository extends  JpaRepository<Employee,Integer> 
{
  
	public Employee findByIdAndPassword(int empId,String password);//we created a queray for password using id and passowrd
//	public Employee findByIdAndPasswordAndRole(int empId,String password,String role);//for create condisanational Login page
}
