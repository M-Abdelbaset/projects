package com.test.callback;

import java.util.Properties;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class CallbackUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {ParentWithCallbackMethods.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Test
	@Disabled
	public void testCallbackMethods() {
		ParentWithCallbackMethods parent = 
				new ParentWithCallbackMethods();
		parent.setName("parent name");
		
		masterEM.getTransaction().begin();
		masterEM.persist(parent);
		masterEM.getTransaction().commit();
		
		newEntityManager().find(ParentWithCallbackMethods.class, parent.getId());
	}
	
	@Test
	public void testCallbackListner() {
		ParentWithCallbackMethods parent = 
				new ParentWithCallbackMethods();
		parent.setName("parent name");
		
		masterEM.getTransaction().begin();
		masterEM.persist(parent);
		masterEM.getTransaction().commit();
		
		newEntityManager().find(ParentWithCallbackMethods.class, parent.getId());
	}
}
