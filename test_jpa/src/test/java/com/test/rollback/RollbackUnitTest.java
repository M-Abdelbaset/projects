package com.test.rollback;

import java.util.Properties;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class RollbackUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Child.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

 //   @Test
	public void testRollback() {
		
		Child c1 = new Child(null, "name", 1);
		
		masterEM.getTransaction().begin();
		masterEM.persist(c1);
		masterEM.getTransaction().rollback();
	}

    @Test
	public void testRollbackOnly() {
		
    	Child c1 = new Child(null, "name", 1);
		
		masterEM.getTransaction().begin();
		masterEM.getTransaction().setRollbackOnly();
		masterEM.persist(c1);
		masterEM.getTransaction().commit();
	}
}
