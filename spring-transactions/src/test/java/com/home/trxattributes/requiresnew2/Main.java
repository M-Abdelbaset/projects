package com.home.trxattributes.requiresnew2;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

		CustomerFacade customerFacade = ctx.getBean(CustomerFacade.class);

		System.out.println(customerFacade.count());		
		
		try {
			customerFacade.persistv2();
		} catch (Exception e) {}
		
		System.out.println(customerFacade.count());

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
	public LocalContainerEntityManagerFactoryBean factoryBean() {
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = 
				new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "create");

		entityManagerFactoryBean.setPackagesToScan("com.home.trxattributes.requiresnew2");
		entityManagerFactoryBean.setJpaProperties(hibernateProperties);
		
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return entityManagerFactoryBean;
	}
	
	@Bean
	public JpaTransactionManager jpaTransactionManager() {
		return new JpaTransactionManager(factoryBean().getObject());
	}
}
