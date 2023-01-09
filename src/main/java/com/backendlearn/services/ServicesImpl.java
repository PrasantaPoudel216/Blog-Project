package com.backendlearn.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendlearn.dto.UsersDto;
import com.backendlearn.entity.Users;
import com.backendlearn.exceptions.ResourceNotFoundException;
import com.backendlearn.repository.Usersrepo;

@Service
public class ServicesImpl implements UsersService {

	@Autowired
	private Usersrepo userrepo;

	@Autowired
	private ModelMapper modelmapper;

	private Users usersmodel;

	@Override
	public UsersDto crateUser(UsersDto user) {

		usersmodel = modelmapper.map(user, Users.class);
		return modelmapper.map((userrepo.save(usersmodel)), UsersDto.class);

	}

	@Override
	public UsersDto updateUser(UsersDto user, Integer userid) {

		usersmodel = userrepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("user", "id", userid));

		usersmodel.setName(user.getName());
		usersmodel.setEmail(user.getEmail());
		usersmodel.setPassword(user.getPassword());
		usersmodel.setAbout(user.getAbout());

		return this.usersmodeltodto(userrepo.save(usersmodel));

	}

	@Override
	public List<UsersDto> getUsers() {
		// TODO Auto-generated method stub

		List<Users> users = userrepo.findAll();

		List<UsersDto> usersdto = new ArrayList<UsersDto>();

		for (Users usersmodel : users) {

			usersdto.add(new UsersDto(usersmodel.getId(), usersmodel.getName(), usersmodel.getEmail(),
					usersmodel.getPassword(), usersmodel.getAbout()));

		}

		return usersdto;
	}

	@Override
	public UsersDto getUser(Integer id) {
		// TODO Auto-generated method stub

		usersmodel = userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));

		return modelmapper.map(usersmodel,UsersDto.class);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		usersmodel = userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));

		userrepo.deleteById(usersmodel.getId());

	}

	UsersDto usersmodeltodto(Users usermodel) {

		UsersDto usersdto = new UsersDto();
//		
//		usersdto.setId(usermodel.getId());
//		usersdto.setName(usermodel.getName());
//		usersdto.setEmail(usermodel.getEmail());
//		usersdto.setPassword(usermodel.getPassword());
//		usersdto.setAbout(usermodel.getAbout());
//		return usersdto;
//		

		usersdto = this.modelmapper.map(usermodel, UsersDto.class);
		return usersdto;

	}

	Users usersdtotousersmodel(UsersDto usersdto) {
//		usersmodel=new Users();
//		 usersmodel.setId(usersdto.getId());
//		usersmodel.setName(usersdto.getName());
//		usersmodel.setEmail(usersdto.getEmail());
//		usersmodel.setPassword(usersdto.getPassword());
//		usersmodel.setAbout(usersdto.getAbout());
//		return usersmodel;

		usersmodel = this.modelmapper.map(usersdto, Users.class);
		return usersmodel;

	}

}
