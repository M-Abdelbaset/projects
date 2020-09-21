package com.example.demo;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DBConfig {

	@Autowired DataSource dataSource;
	
	/*
	@Bean 
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test_hibernate?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("Passw0rd");
		
		return ds;
	}
*/	
	/*
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactory());
	}

	@Bean(name="entityManagerFactory")
	public SessionFactory sessionFactory() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
	//	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
		
		return new LocalSessionFactoryBuilder(dataSource)
				.scanPackages("com.example.demo.entity")
				.addProperties(properties)
				.buildSessionFactory();
	}*/
}
