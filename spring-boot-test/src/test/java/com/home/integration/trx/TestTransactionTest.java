package com.home.integration.trx;

import static org.hamcrest.CoreMatchers.is;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.transaction.TestTransaction;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringJUnitConfig
public class TestTransactionTest extends AbstractMySqlTest {

	@Autowired SessionFactory sf;
	@Autowired JdbcTemplate jdbcTemplate;
	
	@Test
	@Transactional
	void test() {
		
		// setup
		int rowsInTable = countRows();
		
		// run
		sf.getCurrentSession().persist(new Student()); // runs within the declarative transaction
		
		// assert
		assertThat(countRows(), is(rowsInTable+1));
		System.out.println(countRows());
		TestTransaction.end(); // causes the transaction to rollback
		
		// run
		TestTransaction.start();
		TestTransaction.flagForCommit(); // will commit
		sf.getCurrentSession().persist(new Student()); // will be committed
		// assert
		assertThat(countRows(), is(rowsInTable+1));
		TestTransaction.end();
	}
}
