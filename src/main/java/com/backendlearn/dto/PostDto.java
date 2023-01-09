package com.backendlearn.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.backendlearn.entity.Category;
import com.backendlearn.entity.Comments;
import com.backendlearn.entity.Users;

public class PostDto {

	private int id;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UsersDto users;
	private Set<CommentsDto> comments=new HashSet<>();
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UsersDto getUsers() {
		return users;
	}

	public void setUsers(UsersDto users) {
		this.users = users;
	}

	public Set<CommentsDto> getComments() {
		return comments;
	}

	public void setComments(Set<CommentsDto> comments) {
		this.comments = comments;
	}

	

	
	
}
