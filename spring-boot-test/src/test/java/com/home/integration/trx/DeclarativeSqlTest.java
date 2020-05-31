package com.home.integration.trx;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringJUnitConfig
public class DeclarativeSqlTest extends AbstractMySqlTest {
	
	@Autowired SessionFactory sf;
	
	@Test
	@Sql(statements = {"delete from student where id=100", 
						"insert into student(id, name) values (100, 'sql');"})
	@Transactional
	void test() {		
		Student student = 
				sf.getCurrentSession().find(AbstractMySqlTest.Student.class, 100);
		
		assertThat(student, notNullValue());
		assertThat(student.getName(), is("sql"));
	}
}
