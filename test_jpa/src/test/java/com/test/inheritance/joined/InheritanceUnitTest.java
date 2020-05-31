package com.test.inheritance.joined;

import java.util.Properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class InheritanceUnitTest extends AbstractJPATest{

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Parent.class, Child1.class, Child2.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	@Test
	@Disabled
	public void persist() {
		
		masterEM.getTransaction().begin();
		
		Child1 c1 = new Child1("parent 1", "child 1");
		masterEM.persist(c1);
		
		Child2 c2 = new Child2("parent 2", "child 2");
		masterEM.persist(c2);
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	public void select() {
		masterEM.find(Child1.class, 1);
	}
}
