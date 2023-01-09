package com.backendlearn.utils;

public interface UsersSqlQueries {
	
	String INSERTQUERY="insert into users (user_name,user_about,user_email,user_password) values"
			+ "(?,?,?,?)";
	String SELECTQUERY="select * from users";
	String GET_SINGLE_USER="select * from users where id=?";
	String UPDATE_QUERY="update users set user_name=?,user_about=?,user_email=?,user_password=?"
			+ "where id=?";
	String GET_ID_OF_USER="select id from users where user_name=?;";

}
