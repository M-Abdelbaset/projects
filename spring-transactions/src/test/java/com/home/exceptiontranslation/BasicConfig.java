package com.home.exceptiontranslation;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class BasicConfig {
	
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
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("com.home.exceptiontranslation");

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		localSessionFactoryBean.setHibernateProperties(hibernateProperties);

		return localSessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		return new HibernateTransactionManager(sessionFactory().getObject());
	}

}