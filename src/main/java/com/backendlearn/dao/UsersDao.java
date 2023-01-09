package com.backendlearn.dao;

import org.springframework.stereotype.Repository;

import com.backendlearn.dto.UsersDto;
import com.backendlearn.entity.Users;
import com.backendlearn.utils.UsersSqlQueries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class UsersDao implements UsersSqlQueries {

	@Autowired
	private JdbcTemplate jdbcTemplateObj;

	private DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource() {

		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	public Integer insertData(Users users) {
		int insertedRows = jdbcTemplateObj.update(INSERTQUERY,new Object[] { users.getName(), users.getAbout(), users.getEmail(),
				users.getPassword()});

		return insertedRows;
	}
	
	

	public List<UsersDto> getAllUsers() {
		List<UsersDto> allUsers = jdbcTemplateObj.query(SELECTQUERY,
				(rs, rownum) -> new UsersDto(rs.getInt("id"), rs.getString("user_name"), rs.getString("user_about"),
						rs.getString("user_email"), rs.getString("user_password")));
		// or (rs,rownum)->new UsersDto(rs.getInt(Id));

		return allUsers;
	}

	public UsersDto getSingleUser(Integer id) {
		
		try {
		return (UsersDto) jdbcTemplateObj.queryForObject(GET_SINGLE_USER, new Object[] { id },
				(rs, rownum) -> new UsersDto(rs.getInt("id"), rs.getString("user_name"), rs.getString("user_about"),
						rs.getString("user_email"), rs.getString("user_password")));
		}catch(EmptyResultDataAccessException e)
		{
			return null;
		}
		
	}
	
	public Integer updateUsers(UsersDto usersDto) {
		
		return jdbcTemplateObj.update(UPDATE_QUERY,usersDto.getName(),usersDto.getAbout()
				,usersDto.getEmail(),usersDto.getPassword(),usersDto.getId());
		
	}
	public Integer getuserid(String name)
	{
		
		return jdbcTemplateObj.queryForObject(GET_ID_OF_USER,new Object[] {name},Integer.class);
		
	}

}
