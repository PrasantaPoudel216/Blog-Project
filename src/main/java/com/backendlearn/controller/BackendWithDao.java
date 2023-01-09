package com.backendlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.backendlearn.utils.UsersMessage;
import com.backendlearn.helper.UsersHelper;
import com.backendlearn.payloads.Response;
import com.backendlearn.services.UsersServicedao;
import com.backendlearn.validator.UsersValidator;
import com.backendlearn.dao.UsersDao;
import com.backendlearn.dto.UsersDto;

@RestController
@RequestMapping("/api")
public class BackendWithDao implements UsersMessage {

	@Autowired
	UsersHelper usersHelper;

	@Autowired
	UsersServicedao userServiceDao;

	@Autowired
	UsersDto usersDto;
	
	@Autowired
	UsersDao usersdao;

	@PostMapping(value = "/insertuser", consumes = "application/json")
	public Response insertUser(@RequestBody String applicationInsertionJson) {
		Response response = new Response();

		System.out.println(applicationInsertionJson);
		List<String> validationErrors = UsersValidator.validateInsertingUsers(applicationInsertionJson);
		if (validationErrors.isEmpty()) {
			usersDto = usersHelper.saveUser(applicationInsertionJson);
			userServiceDao.insertUser(usersDto);
			response.setState(true);
			response.setMessage(DATA_SAVED);
			response.setObject(usersDto);
		} else {
			response.setState(false);
			response.setMessage(ERROR);
			response.setObject(validationErrors);
		}

		return response;
	}

	@GetMapping(value = "/getallusers")
	public Response getUsers() {
		Response response = new Response();

		List<UsersDto> usersDto = userServiceDao.getAllUsers();
		if (usersDto.isEmpty()) {
			response.setMessage(DATA_NOT_FOUND);
			response.setState(false);

		} else {

			response.setMessage(DATA_FOUND);
			response.setState(true);
			response.setObject(usersDto);
		}

		return response;
	}

	@GetMapping(value = "/getsingleuser", params = { "userid", "name" })
	public Response getSingleUser(@RequestParam("userid") Integer id, @RequestParam("name") String name) {
		Response response = new Response();
		usersDto = userServiceDao.getUserById(id);

		if (usersDto == null) {
			response.setMessage(DATA_NOT_FOUND);
			response.setState(false);
		} else {
			response.setMessage(DATA_FOUND);
			response.setState(true);
			response.setObject(usersDto);

			System.out.println(name);
		}

		return response;
	}

	@PutMapping(value = "/updateuser", consumes = "application/json")
	public Response updateUserdetail(@RequestBody String applicationUpdateJson) {

		Response response = new Response();

		List<String> validationErrors = UsersValidator.validateUpdateUsers(applicationUpdateJson);
		if (validationErrors.isEmpty()) {
			usersDto = usersHelper.updateUser(applicationUpdateJson);
			userServiceDao.updateUserById(usersDto);
			response.setMessage(DATA_UPDATED);
			response.setObject(usersDto);
			response.setState(true);

		} else {
			response.setMessage(ERROR);
			response.setState(false);
			response.setObject(validationErrors);
		}

		return response;
	}
	
	@GetMapping("/getuserid")
public void getuserid()
{
		
		UsersDao dao=new UsersDao();
		System.err.println(dao.getuserid("kasmi"));
	
}

}
