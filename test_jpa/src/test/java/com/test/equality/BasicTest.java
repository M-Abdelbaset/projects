package com.test.equality;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

class BasicTest extends AbstractJPATest{

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Company.class, Student.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
	//	properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}
	
//	@Test
	public void whenNoEqualsIsOverriden_thenObjectsAreNotEqualInStates() {
		Company c1 = new Company();
	//	c1.setId(1);
		Company c2 = new Company();
	//	c2.setId(1);
		
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		assertFalse(c1.hashCode() == c2.hashCode());
	}
	
	@Test
	public void testLazyInitialize() {
		
		masterEM.getTransaction().begin();
		
		Company company = new Company();
		masterEM.persist(company);
		
		Student student = new Student();
		student.setCompany(company);
		masterEM.persist(student);
		
		masterEM.getTransaction().commit();
		
		newEntityManager().createQuery("from Student s", Student.class).getResultList();
	}
}
