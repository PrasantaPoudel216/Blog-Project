package com.backendlearn.payloads;

import java.util.List;

import com.backendlearn.dto.UsersDto;

public class Response {

	private Object object;
	private String message;
	private boolean state;
	
	
	
	
	
	
	
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(Object object, String message, boolean state) {
		super();
		this.object = object;
		this.message = message;
		this.state = state;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
	
}
	
