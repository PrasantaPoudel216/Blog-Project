package com.backendlearn.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.backendlearn.dao.UsersDao;
import com.backendlearn.dto.UsersDto;
import com.backendlearn.entity.Users;

@Service
public class UsersServicedaoImpl implements UsersServicedao {

	@Autowired
	UsersDao usersdao;

	@Autowired
	ModelMapper modelmapper;

	Users users;

	@Override
	public boolean insertUser(UsersDto usersdto) {

		boolean state = false;

		users = this.dtotomodel(usersdto);
		int insertedRows = usersdao.insertData(users);
		if (insertedRows >= 1) {
			state = true;
		}

		return state;

	}

	@Override
	public List<UsersDto> getAllUsers() {

		List<UsersDto> allUsers = usersdao.getAllUsers();

		return allUsers;
	}

	@Override
	public UsersDto getUserById(Integer id) {

		UsersDto usersDto = usersdao.getSingleUser(id);

		return usersDto;
	}

	@Override
	public void updateUserById(UsersDto usersDto) {
		
		System.out.println(usersdao.updateUsers(usersDto));
		
		

	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub

	}

	private Users dtotomodel(UsersDto usersdto) {
		Users users = new Users();
		users.setName(usersdto.getName());
		users.setAbout(usersdto.getAbout());
		users.setEmail(usersdto.getEmail());
		users.setPassword(usersdto.getPassword());

		return users;

	}
@Override
	public void getid() {
		
		System.out.println(usersdao.getuserid("kasmi"));
	}
}
