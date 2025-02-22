package com_hr.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name="create_post")
@Entity
public class CreatePost {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String title;
	
	@Column(name="Comment",length=2000)
	@NotNull
	private String comment;
	
	private String addedData;

	public CreatePost(int id, String title, String comment, String addedData) {
		super();
		this.id = id;
		this.title = title;
		this.comment = comment;
		this.addedData = addedData;
	}

	public CreatePost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAddedData() {
		return addedData;
	}

	public void setAddedData(String addedData) {
		this.addedData = addedData;
	}

	@Override
	public String toString() {
		return "CreatePost [id=" + id + ", title=" + title + ", comment=" + comment + ", addedData=" + addedData + "]";
	}
	
	
}
