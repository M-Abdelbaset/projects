package com.home.integration.trx;

import static org.hamcrest.CoreMatchers.is;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringJUnitConfig
public class DeclarativeRollbackTest extends AbstractMySqlTest {

	@Autowired SessionFactory sf;
	@Autowired JdbcTemplate jdbcTemplate;
	static int initialCount;
	
	@Test
	@BeforeTransaction
	void checkInitialCount() {
		initialCount = countRows();
	}
	
	@Test
	@Rollback
	@Transactional
	void commit() {
		sf.getCurrentSession().persist(new Student());
	}

	@Test
	@AfterTransaction
	void checkFinalCount() {
		assertThat(countRows(), is(initialCount));
	}
}
