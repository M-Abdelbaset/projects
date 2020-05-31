package com.home.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void persist() {
		jdbcTemplate.update("insert into spring_customer(name) values(null)");
	}
}
