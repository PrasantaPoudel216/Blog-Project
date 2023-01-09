package com.backendlearn.services;

import java.util.List;

import com.backendlearn.dto.UsersDto;

public interface UsersServicedao {

	
	public boolean insertUser(UsersDto usersdto);
	public List<UsersDto> getAllUsers();
	public UsersDto getUserById(Integer id);
	public void updateUserById(UsersDto usersDto);
	public void deleteUser(Integer id);
	public void getid();
	
	
}
