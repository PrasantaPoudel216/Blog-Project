package com.backendlearn.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.backendlearn.dto.UsersDto;
import com.backendlearn.entity.Users;


@Service
public interface UsersService {

	UsersDto crateUser(UsersDto user);
	UsersDto updateUser(UsersDto user,Integer userid);
	List<UsersDto> getUsers();
	UsersDto getUser(Integer id);
    void deleteUser(Integer id);
	
	
}
