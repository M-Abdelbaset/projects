package com.test.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;

@SuppressWarnings("rawtypes")
public class JpaEntityManagerFactory {

//	private final String DB_URL = "jdbc:mysql://localhost:3306/test_hibernate?useSSL=false";
//	private final String DB_USER_NAME = "root";
//	private final String DB_PASSWORD = "Passw0rd";
	private final Class[] entityClasses;
	private final Properties extraProps;
	private EntityManagerFactory emf;
	
	public JpaEntityManagerFactory(Class[] entityClasses, Properties props) {
		this.entityClasses = entityClasses;
		this.extraProps = props;
	}

	public EntityManager getEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}

	protected EntityManagerFactory getEntityManagerFactory() {
		if(emf == null) {
			PersistenceUnitInfo persistenceUnitInfo = getPersistenceUnitInfo(getClass().getSimpleName());
			Map<String, Object> configuration = new HashMap<>();
			emf = new EntityManagerFactoryBuilderImpl(new PersistenceUnitInfoDescriptor(persistenceUnitInfo),
					configuration).build();
		}
		
		return emf;
	}

	protected HibernatePersistenceUnitInfo getPersistenceUnitInfo(String name) {
		return new HibernatePersistenceUnitInfo(name, getEntityClassNames(), getProperties());
	}

	protected List<String> getEntityClassNames() {
		return Arrays.asList(getEntities()).stream().map(Class::getName).collect(Collectors.toList());
	}

	protected Properties getProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "create-drop");
		
		setConnection(extraProps);
		
		for(String key : extraProps.stringPropertyNames()) {
			properties.put(key, extraProps.get(key));
		}
		
		return properties;
	}

	private void setConnection(Properties properties) {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test_hibernate?useSSL=false";
		String user = "root";
		String password = "Passw0rd";
		String dialct = "org.hibernate.dialect.MySQL55Dialect";
		
		if(Boolean.valueOf(properties.getProperty("postgres"))) {
			
			driver = "org.postgresql.Driver";
			url = "jdbc:postgresql://localhost:5432/postgres";
			user = "postgres";
			password = "Passw0rd";
			dialct = "org.hibernate.dialect.PostgreSQLDialect";
			
			properties.remove("postgres");
		}
		
		properties.put("javax.persistence.jdbc.driver", driver);
		properties.put("javax.persistence.jdbc.url", url);
		properties.put("javax.persistence.jdbc.user", user);
		properties.put("javax.persistence.jdbc.password", password);
		properties.put("hibernate.dialect", dialct);
	}
	
	protected Class[] getEntities() {
		return entityClasses;
	}
/*
	protected DataSource getMysqlDataSource() {
		MysqlDataSource mysqlDataSource = new MysqlDataSource();
		mysqlDataSource.setURL(DB_URL);
		mysqlDataSource.setUser(DB_USER_NAME);
		mysqlDataSource.setPassword(DB_PASSWORD);
		return mysqlDataSource;
	}*/
}
