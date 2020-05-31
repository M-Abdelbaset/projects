package com.home.integration.trx;

import static org.hamcrest.CoreMatchers.is;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringJUnitConfig(classes = {SpringManagedTrxTest.StudentService.class})
class SpringManagedTrxTest extends AbstractMySqlTest {

	@Autowired StudentService ss;
	@Autowired SessionFactory sf;
	@Autowired JdbcTemplate jdbcTemplate;
	
	@Test
	@Transactional 
	// The @Transactional annotation must be used so that spring tests manages the transaction
	// which makes it roll it back after end of execution(test-managed transaction). 
	// Otherwise, the test method will change the DB state
	void persist() {

		// setup
		int initialCount = countRows();
		
		// test
		Student student = new Student();
		ss.persist(student);
		sf.getCurrentSession().flush(); // same session factory is used
	
		// verify
		assertThat(countRows(), is(initialCount+1));
	}
	
	@Service
	static class StudentService {
		
		@Autowired SessionFactory sf;
		
		@Transactional
		public void persist(Student student) {
			sf.getCurrentSession().persist(student);
		}
	}
}
