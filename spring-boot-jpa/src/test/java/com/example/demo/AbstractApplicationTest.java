package com.example.demo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.example.demo.repo.ExamRepository;
import com.example.demo.repo.StudentRepository;

@SpringJUnitConfig(classes = {DBConfig.class, ExamRepository.class, StudentRepository.class})
@DataJpaTest
public abstract class AbstractApplicationTest {
	
	@Autowired protected JdbcTemplate jdbcTemplate;
	@Autowired protected SessionFactory sf;
	@Autowired protected ExamRepository examRepository;
	@Autowired protected StudentRepository studentRepository;
	
	protected int count(String table) {
		return JdbcTestUtils.countRowsInTable(jdbcTemplate, table);
	}
}
