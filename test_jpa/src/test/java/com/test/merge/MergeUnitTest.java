package com.test.merge;

import java.util.Properties;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class MergeUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Child.class, Address.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

//	@Test
	public void saveByMerge() {
		
		Child c1 = new Child(null, "name", 1);
		masterEM.merge(c1);
		
		masterEM.getTransaction().begin();
		masterEM.getTransaction().commit();
		
	}
	
	@Test
	public void saveByMerge2() {
		
		Address address = new Address(120, "haram 24 2", 0);
		masterEM.merge(address);
		
		masterEM.getTransaction().begin();
		masterEM.getTransaction().commit();
	}
}
