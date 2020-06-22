package com.home.integration.trx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.TransactionManager;
import lombok.Getter;
import lombok.Setter;

@SpringJUnitConfig(classes = {AbstractMySqlTest.Config.class})
abstract class AbstractMySqlTest {

	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired SessionFactory sf;
	
	protected int countRows() {
		return JdbcTestUtils.countRowsInTable(jdbcTemplate, "student");
	}
	
	protected int countRows(String tableName) {
		return JdbcTestUtils.countRowsInTable(jdbcTemplate, tableName);
	}
	
	@Configuration
	static class Config {
		
		@Bean
		public DataSource dataSource() {
			
			DriverManagerDataSource ds = new DriverManagerDataSource();
			
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/test_hibernate?useSSL=false");
			ds.setUsername("root");
			ds.setPassword("Passw0rd");
			
			return ds;
		}
		
		@Bean
		SessionFactory sessionFactory() {
			return new LocalSessionFactoryBuilder(dataSource())
					.addAnnotatedClass(AbstractMySqlTest.Student.class)
					.setProperty("hibernate.show_sql", "true")
					.setProperty("hibernate.hbm2ddl.auto", "create")
					.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect")
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
		private Integer id;
		@Column(length = 5)
		private String name;
	}
}
