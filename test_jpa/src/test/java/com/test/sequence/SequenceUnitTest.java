package com.test.sequence;

import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.test.AbstractJPATest;

public class SequenceUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] { Parent1.class, Parent2.class };
	}

	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
//		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("postgres", "true");
		return properties;
	}
	
	@Test
	public void insert() {
		
		masterEM.getTransaction().begin();
		
		Parent1 parent1 = new Parent1(null, "parent 1");
		masterEM.persist(parent1);
		Assertions.assertEquals(parent1.getId(), 1);
		
		Parent2 parent2 = new Parent2(null, "parent 2");
		masterEM.persist(parent2);
		Assertions.assertEquals(parent2.getId(), 2);
		
		parent1 = new Parent1(null, "parent 1");
		masterEM.persist(parent1);
		Assertions.assertEquals(parent1.getId(), 3);
		
		parent2 = new Parent2(null, "parent 2");
		masterEM.persist(parent2);
		Assertions.assertEquals(parent2.getId(), 4);
		
		masterEM.getTransaction().commit();
	}
	
}
