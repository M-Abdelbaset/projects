package com.example.demo;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DBConfig {

	@Bean 
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScripts("ddl.sql", "dml.sql")
				.build();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactory());
	}

	@Bean(name="entityManagerFactory")
	public SessionFactory sessionFactory() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return new LocalSessionFactoryBuilder(dataSource())
				.scanPackages("com.example.demo.entity")
				.addProperties(properties)
				.buildSessionFactory();
	}
}
