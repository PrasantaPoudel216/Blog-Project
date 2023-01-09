package com.backendlearn.helper;

import com.backendlearn.dto.UsersDto;
import com.backendlearn.utils.ValidationConstants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class UsersHelper implements ValidationConstants  {
	
	
	
	public UsersDto saveUser(String applicationJson)
	{
            UsersDto usersDto=new UsersDto();
		    JsonObject convertedObj=new Gson().fromJson(applicationJson, JsonObject.class);
			usersDto.setName((convertedObj.get(NAME).toString()).substring(1,(convertedObj.get(NAME).toString()).length()-1));
            usersDto.setAbout(convertedObj.get(ABOUT).toString());
            usersDto.setEmail(convertedObj.get(EMAIL).toString());
            usersDto.setPassword(convertedObj.get(PASSWORD).toString());
		return usersDto;
	}
	
	public UsersDto updateUser(String updateJson)
	{
		UsersDto usersDto=new UsersDto();
		JsonObject convertedObj=new Gson().fromJson(updateJson,JsonObject.class);
		usersDto.setId(convertedObj.get(ID).getAsInt());
		usersDto.setName(convertedObj.get(NAME).toString());
		usersDto.setAbout(convertedObj.get(ABOUT).toString());
		usersDto.setEmail(convertedObj.get(EMAIL).toString());
		usersDto.setPassword(convertedObj.get(PASSWORD).toString());
		return usersDto;
		
	}
	
	

}
