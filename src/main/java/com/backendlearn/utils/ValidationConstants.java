package com.backendlearn.utils;

public interface ValidationConstants {
	
	
	
	///constants
	String ID="id";
	String NAME="name";
	String ABOUT="about";
	String EMAIL="email";
	String PASSWORD="password";
	
	/////Missing///
	String ID_MISSING="Users id is missed";
	String NAME_MISSING="Users name is missed";
	String ABOUT_MISSING="Users about is missed";
	String EMAIL_MISSING="Users email is missed";
	String PASSWORD_MISSING="Users password is missed";
	
	
	
	
	
	
	
	
	//////////formats //////////
	String NAME_FORMAT_MISSING="Users name cannot be null,empty or \"\"";
    String ABOUT_FORMAT_MISSING="Users about cannot be null,empty or \"\"";
    String EMAIL_FORMAT_MISSING="Users email format is wrong";
    String PASSWORD_FORMAT_MISSING="Users password format is wrong";
}
