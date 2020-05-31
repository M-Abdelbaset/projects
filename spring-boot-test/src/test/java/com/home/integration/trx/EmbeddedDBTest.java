package com.home.integration.trx;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.TransactionManager;

import static org.hamcrest.MatcherAssert.assertThat;

import lombok.Getter;
import lombok.Setter;

@SpringJUnitConfig(classes = {EmbeddedDBTest.Config.class})
class EmbeddedDBTest {

	@Autowired SessionFactory sf;
	@Autowired JdbcTemplate jdbcTemplate;
	
	@Transactional
	@Test
	void test() {
		
		// setup
		int initialCount = JdbcTestUtils.countRowsInTable(jdbcTemplate, "student");
		
		// test
		Student student = new Student();
		sf.getCurrentSession().persist(student);
		sf.getCurrentSession().flush(); // manually flush to avoid false positives
		
		// verify
		assertThat(student.getId(), notNullValue());
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "student"), is(initialCount+1));
	}
	
	@Configuration
	static class Config {
		
		@Bean
		DataSource dataSource() {
			return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.H2)
					.addScripts("ddl.sql", "dml.sql")
					.build();
		}
		
		@Bean
		SessionFactory sessionFactory() {
			return new LocalSessionFactoryBuilder(dataSource())
					.addAnnotatedClass(EmbeddedDBTest.Student.class)
					.setProperty("hibernate.show_sql", "true")
					.buildSessionFactory();
		}
		
		@Bean
		TransactionManager transactionManager() {
			return new HibernateTransactionManager(sessionFactory());
		}
		
		@Bean
		JdbcTemplate jdbcTemplate() {
			return new JdbcTemplate(dataSource());
		}
	}
	
	@Entity(name="Student")
	@Table(name="student")
	@Setter @Getter
	static class Student {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
	}
}
