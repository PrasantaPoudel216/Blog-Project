package com.backendlearn.dto;

public class JwtAuthDto {

	private String username;
	private String password;

	public JwtAuthDto() {
		super();
	}

	public JwtAuthDto(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
