package com_hr.Entity;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee_registration")
public class Employee 
{
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="Employee_Name",length=100)//this is use to change attribute name
	@NotBlank(message="Name is requed") //this is called serverSide Validation
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") //this is called serverSide Validation
	private String employeeName;
	
	private String gender;
	private String mobile;
	
	@Email(message="Email is needed")//this is called serverSide Validation
	private String email;
	private String dateOfBirth;
	private String joiningDate;
	private String aadhaarNo;
	private String accountNo;
	private String previousCompany;
	private String pfNumber;
	private String salary;
	
	@Size(min=3,max=1000,message="message must be between 3 to 1000 charecter")
	private String currentAddress;
	
	@Size(min=3,max=1000,message="message must be between 3 to 1000 charecter")
	private String permanentAddress;
	private String department;
	private String designation;
	private boolean status=true;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	private String password;
	
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Employee() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPreviousCompany() {
		return previousCompany;
	}
	public void setPreviousCompany(String previousCompany) {
		this.previousCompany = previousCompany;
	}
	public String getPfNumber() {
		return pfNumber;
	}
	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", gender=" + gender + ", mobile=" + mobile
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", joiningDate=" + joiningDate + ", aadhaarNo="
				+ aadhaarNo + ", accountNo=" + accountNo + ", previousCompany=" + previousCompany + ", pfNumber="
				+ pfNumber + ", salary=" + salary + ", currentAddress=" + currentAddress + ", permanentAddress="
				+ permanentAddress + ", department=" + department + ", designation=" + designation + ", status="
				+ status + ", getId()=" + getId() + ", getEmployeeName()=" + getEmployeeName() + ", getGender()="
				+ getGender() + ", getMobile()=" + getMobile() + ", getEmail()=" + getEmail() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getJoiningDate()=" + getJoiningDate() + ", getAadhaarNo()=" + getAadhaarNo()
				+ ", getAccountNo()=" + getAccountNo() + ", getPreviousCompany()=" + getPreviousCompany()
				+ ", getPfNumber()=" + getPfNumber() + ", getSalary()=" + getSalary() + ", getCurrentAddress()="
				+ getCurrentAddress() + ", getPermanentAddress()=" + getPermanentAddress() + ", getDepartment()="
				+ getDepartment() + ", getDesignation()=" + getDesignation() + ", isStatus()=" + isStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee(LocalDateTime createDate, LocalDateTime updateDate, String password) {
		super();
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.password = password;
	}
	
	
	
	
	
}
