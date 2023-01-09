package com.backendlearn.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersDto {

	private int id;

	@NotEmpty
	@Size(min = 3, max = 50, message = "The name should be min 3 and max 50 characters")
	private String name;

	@NotEmpty
	@Size(min = 3, max = 20, message = "The email should be min 3 and max 20 characters")
	private String email;

	@NotEmpty(message = "Password cannot be empty or null")
	private String password;

	@NotEmpty
	@Size(min = 1, max = 20, message = "should be at least 1 character")
	private String about;

	private String modify;

	public String getModify() {
		return modify;
	}

	public void setModify(String modify) {
		this.modify = modify;
	}

	public UsersDto() {
	};

	public UsersDto(String name, String email, String password, String about) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public UsersDto(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
