package com.home.integration.trx;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class FalsePositiveTest extends AbstractMySqlTest {

	@Autowired SessionFactory sf;
	@Autowired JdbcTemplate jdbcTemplate;
	Student student;
	
	@BeforeEach
	void init() {
		student = new Student();
	}
	
	@Transactional
	@Test
	void falsePositive() {
		
		// test
		student.setName("123");
		sf.getCurrentSession().persist(student);
		
		// update name with invalid length
		student.setName("1234567"); // will take place at flush time!
	}
	
	@Transactional
	@Test
	void nonFalsePositive() {
		
		Assertions.assertThrows(Exception.class, () -> {
			// test
			student.setName("123");
			sf.getCurrentSession().persist(student);
			sf.getCurrentSession().flush();
			
			// update name with invalid length
			student.setName("1234567");
			sf.getCurrentSession().flush();
		});
	}
}
