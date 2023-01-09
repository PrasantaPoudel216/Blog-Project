package com.backendlearn.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendlearn.dao.UsersRepo;
import com.backendlearn.dto.UsersDto;
import com.backendlearn.payloads.Response;
import com.backendlearn.services.UsersService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class Usercontroller {

	@Autowired
	private UsersService usersservice;

	@Autowired
	UsersRepo udao;

	@PostMapping("/createuser")
	public Response createUser(@Valid @RequestBody UsersDto newuser) {

		return new Response(usersservice.crateUser(newuser), "Created Successfully", true);
	}

	@PutMapping("/updateuser/{userid}")
	public Response updateUser(@Valid @RequestBody UsersDto updateuser, @PathVariable Integer userid) {
		return new Response(usersservice.updateUser(updateuser, userid), "updated successfully", true);

	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getusers")
	public Response getUsers() {

		return new Response(usersservice.getUsers(), "Successfully found", true);
	}

	@GetMapping("/getuser/{userId}")
	public Response getUser(@PathVariable Integer userId) {

		if (userId < 6) {
			return new Response(null, "plz enter greater id than " + userId, false);

		}
		return new Response(usersservice.getUser(userId), "Successfully found", true);

	}

	@DeleteMapping("/deleteuser/{userId}")
	public Response deleteUser(@PathVariable Integer userId) {

		usersservice.deleteUser(userId);
		System.out.println("Deleted Successfully");
		return new Response(usersservice.getUsers(), "deleted successfully", true);

	}

	@GetMapping("/responsetest")
	public void responseTest() throws ClassNotFoundException {
		Response response = this.getUser(6);

		System.out.println("//////////////////direct show");
		System.out.println(response);

		System.out.println(response.getClass());

		UsersDto userdto = (UsersDto) response.getObject();
		System.out.println("//////////////////////////////////////////dto convert");
		System.out.println(userdto.getAbout());
		System.out.println(userdto.getEmail());
		System.out.println(userdto.getName());
		System.out.println(userdto.getPassword());

		System.out.println("//////////////////object convert");
		Object dto = response.getObject();

		System.out.println(dto);

	}

	@GetMapping("/test")
	public List<UsersDto> tests() {
		Response response = getUsers();

		List<UsersDto> dtolists = (List<UsersDto>) response.getObject();

		for (UsersDto dto : dtolists) {
			dto.setModify("modified");

		}

		return dtolists;
	}

	@GetMapping(value = "/savewithjson", consumes = "application/json")
	public Response savewithjson(@RequestBody String applicationjson) {
		Response response = new Response();

		final String errorstring = "the name shouldn't be empty, null or \"\" values";

		JsonObject convertedjsonobject = new Gson().fromJson(applicationjson, JsonObject.class);

		if (convertedjsonobject.has("name")) {

			String name = convertedjsonobject.get("name").toString();
			if (name.isEmpty() || name.isBlank() || name.equals("\"\"")) {

				System.out.println(errorstring);
				response.setMessage("enter a name please " + name);
			} else {
				System.out.println((convertedjsonobject.get("name")).toString());

				response.setMessage("found");
				response.setState(true);
			}

		}

		else {

			response.setMessage("not found");
			response.setState(false);
			System.out.println(convertedjsonobject);
		}

		return response;

	}

	@PutMapping("/updatebydao")
	public void updateByDao() {

		udao.update(9);

	}

}
