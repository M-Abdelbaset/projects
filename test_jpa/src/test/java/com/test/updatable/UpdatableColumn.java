package com.test.updatable;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Properties;
import java.util.UUID;

import org.hibernate.Session;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class UpdatableColumn extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Student.class};
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
		Student s = new Student();
		s.setName("ahmed");
		s.setAge(1);
		
		masterEM.getTransaction().begin();
		masterEM.persist(s);
		masterEM.getTransaction().commit();
	}	
	
	@Test
	@Disabled
	public void whenUpdatableIsFalse_updateProhibited() {

		assertThrows(Exception.class, () -> {
			Student s = masterEM.unwrap(Session.class)
					.bySimpleNaturalId(Student.class)
					.load("mohamed");
			s.setName("yasser");

			masterEM.getTransaction().begin();
			masterEM.persist(s);
			masterEM.getTransaction().commit();

		});

	}
}
