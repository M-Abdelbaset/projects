package com.test.key.composite;

import org.hibernate.Session;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;
import java.util.UUID;

public class CompositeKeyTest extends AbstractJPATest{

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Employee.class, Phone.class, Company.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
	//	properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}
	
	@Test
//	@Disabled
	public void persist() {
		masterEM.getTransaction().begin();
		
		Company c1 = new Company("first com");
		masterEM.persist(c1);
		
		Employee e1 = new Employee(c1, "first employee");
		
		Phone p1 = new Phone(UUID.randomUUID().toString(), e1);
		Phone p2 = new Phone(UUID.randomUUID().toString(), e1);
		Phone p3 = new Phone(UUID.randomUUID().toString(), e1);
		
		e1.addPhone(p1);
		e1.addPhone(p2);
		e1.addPhone(p3);
		
				
		masterEM.persist(e1);
		
		masterEM.getTransaction().commit();
	}
	
//	@Test
	public void find() {
		masterEM.getTransaction().begin();
		
		Employee e1 = masterEM.unwrap(Session.class).bySimpleNaturalId(Employee.class).load("first employee");
		assertEquals(3, e1.getPhones().size());
		
		masterEM.getTransaction().commit();
	}
}
