package com.backendlearn;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.backendlearn.dto.UsersDto;
import com.backendlearn.entity.Users;
import com.backendlearn.repository.Usersrepo;
import com.backendlearn.services.UsersService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTest {

	@MockBean
	Usersrepo usersRepo;

	@Autowired
	UsersService userService;

	@MockBean
	ModelMapper modelMapper;

	@Autowired
	ModelMapper modelMappers;

	@Test
	public void testGetUsers() {
		List<Users> users = new ArrayList<>();
		users.add(new Users(1, "Rakul", "Rakul@gmail.com", "Rakullovesme", "A good pilot"));
		users.add(new Users(1, "urvasi", "Urvasi@gmail.com", "Urvasiovesme", "A good pilot"));

		when(usersRepo.findAll()).thenReturn(users);
		assertEquals(2, userService.getUsers().size());

	}

	@Test
	public void TestGetById() {
		Optional<Users> users = Optional.of(new Users(1, "Rakul", "Rakul@gmail.com", "Rakullovesme", "A good pilot"));

		when(usersRepo.findById(1)).thenReturn(users);
		UsersDto usersDto = modelMappers.map((users.get()), UsersDto.class);

		when(modelMapper.map(users, UsersDto.class)).thenReturn(usersDto);

		assertEquals(usersDto, userService.getUser(1));

	}

	@Test
	public void testCreateUsers() {
		Users users = new Users(1, "Rakul", "Rakul@gmail.com", "Rakullovesme", "A good pilot");
		UsersDto dto = new UsersDto();

		dto.setId(users.getId());
		dto.setName(users.getName());
		dto.setEmail(users.getEmail());
		dto.setAbout(users.getAbout());
		dto.setPassword(users.getPassword());

		when(modelMapper.map(dto, Users.class)).thenReturn(users);
		when(modelMapper.map(users, UsersDto.class)).thenReturn(dto);
		when(usersRepo.save(users)).thenReturn(users);

		assertEquals(dto, userService.crateUser(dto));

	}

	@Test
	public void testDeleteUsers() {
		userService.deleteUser(1);

		verify(usersRepo, times(1)).deleteById(1);
	}
}
