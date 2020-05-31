package com.test.connection;

import java.util.Properties;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class ConnectionUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {};
	}
	
	@Override
	protected Properties getProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}

	@Test
	public void emToConnectionMapping() throws InterruptedException {
		
		Thread.sleep(10000);
		
		masterEM.close();
		System.out.println("Closed EM...");
		Thread.sleep(10000);
		EntityManager em1 = newEntityManager();
		EntityManager em2 = newEntityManager();
		Thread.sleep(10000);
		em1.close();
		em2.close();
		Thread.sleep(10000);
	}
}
