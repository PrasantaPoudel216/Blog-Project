package com.backendlearn.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private String user;
	private String fieldname;
	private Integer userid;

	public ResourceNotFoundException(String user, String fieldname, Integer userid) {
		super(String.format("user not found with id %d", userid));
		this.user = user;
		this.fieldname = fieldname;
		this.userid = userid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
