package com.test.optimisticlocking;

import java.util.Properties;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class OptimisticLockingUsingVersionUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {OptimisticChild.class};
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
		masterEM.persist(new OptimisticChild());
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void persistWithOverflowVersion() {
		masterEM.getTransaction().begin();
		
		OptimisticChild child = new OptimisticChild();
		child.setVersion(Short.MAX_VALUE);
	
		masterEM.persist(child);
		masterEM.getTransaction().commit();
		
	}
	
	@Test
//	@Disabled
	public void updateOverflowedVersion() {
		masterEM.getTransaction().begin();
		
		OptimisticChild child = masterEM.find(OptimisticChild.class, 5);
		child.setName("name");
		
		masterEM.getTransaction().commit();
		
	}
	
	@Test
	@Disabled
	public void update() {
		masterEM.getTransaction().begin();
		OptimisticChild child = masterEM.find(OptimisticChild.class, 1);
		child.setName("name " + UUID.randomUUID());
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void updateDirty() {
		OptimisticChild child = masterEM.find(OptimisticChild.class, 1);
		
		System.out.println("\n");
		
		EntityManager slave = newEntityManager();
		slave.getTransaction().begin();
		OptimisticChild child2 = slave.find(OptimisticChild.class, 1);
		child2.setName(UUID.randomUUID().toString());
		slave.getTransaction().commit();
		
		System.out.println("\n");
		
		masterEM.getTransaction().begin();
		child.setName(UUID.randomUUID().toString()); // transaction and persistence context are aborted
		// persistence context will be updated with the newer version number
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void deleteDirty() {
		OptimisticChild child = masterEM.find(OptimisticChild.class, 1);
		
		System.out.println("\n");
		
		EntityManager slave = newEntityManager();
		slave.getTransaction().begin();
		OptimisticChild child2 = slave.find(OptimisticChild.class, 1);
		child2.setName(UUID.randomUUID().toString());
		slave.getTransaction().commit();
		
		System.out.println("\n");
		
		masterEM.getTransaction().begin();
		masterEM.remove(child);
		masterEM.getTransaction().commit();
	}
}