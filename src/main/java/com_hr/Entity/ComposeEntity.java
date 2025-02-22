package com_hr.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="compose")	
public class ComposeEntity 
{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String empName;
	
	@Column(name="text",length=2000)
	private String text;
	
	private String subject;
	
	private int parentUkid;
	
	private String role;
	
	public ComposeEntity(String role) {
		super();
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ComposeEntity(int parentUkid) {
		super();
		this.parentUkid = parentUkid;
	}

	public void setParentUkid(int parentUkid) {
		this.parentUkid = parentUkid;
	}

	private String status;
	
	private String addedDate;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@CreationTimestamp
	private LocalDateTime updateDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	

	public int getParentUkid() {
		return parentUkid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
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

	@Override
	public String toString() {
		return "ComposeEntity [id=" + id + ", empName=" + empName + ", text=" + text + ", subject=" + subject
				+ ", parentUkid=" + parentUkid + ", status=" + status + ", addedDate=" + addedDate + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}

	public ComposeEntity(int id, String empName, String text, String subject, String parentUkid, String status,
			String addedDate, LocalDateTime createDate, LocalDateTime updateDate) {
		super();
		this.id = id;
		this.empName = empName;
		this.text = text;
		this.subject = subject;
		
		this.status = status;
		this.addedDate = addedDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public ComposeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
