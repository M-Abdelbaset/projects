package com.home.trxlistener;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Main.class);

	//	ctx.getBean(CustomerService.class).persist();
	
		try {
			ctx.getBean(CustomerService.class).rollback();
		} catch (Exception e) {}
		
		ctx.close();
	}

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
		localSessionFactoryBean.setPackagesToScan("com.home.trxlistener");

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
