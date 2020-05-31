package com.test.jpql;

import java.util.Properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.AbstractJPATest;
import com.test.cascade.onetomany.Child;
import com.test.cascade.onetomany.Parent;

public class SelectUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] { Parent.class, Child.class };
	}

	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Test
	@Disabled
	public void selectChildrenOnly() {
		System.out.println(
				masterEM.createQuery("select p.children from Parent p "
						+ "where p.id=:parentId")
				.setParameter("parentId", 1)
				.getResultList()
		);
		
	}
	
	@Test
	public void selectProperties() {
		Object[] result;
		
		result = masterEM.createQuery("select p.id, p.name from Parent p "
				+ "where p.id=:parentId", Object[].class)
		.setParameter("parentId", 1)
		.getSingleResult();
		
		for(Object obj : result)
			System.out.println(obj);
	}

}
