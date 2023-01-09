package com.backendlearn.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;



@Repository
public class UsersRepo {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void update(Integer id) {
		
	
		String query="select max(id) from users";
		
		String s=new JdbcTemplate(dataSource).queryForObject(query,String.class);
		
		Integer i=Integer.parseInt(s);
		
		int username=45;
		query="update users set user_name=?1 where id=?2";
		
		jdbcTemplateObject.execute(query,new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1,i);
				ps.setInt(2,id);
				return true;
			}
		});
		
		
	}
	
}
