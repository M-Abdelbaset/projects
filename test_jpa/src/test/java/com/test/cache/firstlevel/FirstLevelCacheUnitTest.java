package com.test.cache.firstlevel;

import java.util.Properties;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class FirstLevelCacheUnitTest extends AbstractJPATest {

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

//	@Test
	public void hqlQueryUsesFirstLevelCache() {
		
		Child child = new Child()
				.setName("child")
				.setAge(1);
		
		masterEM.getTransaction().begin();
		masterEM.persist(child);
		masterEM.getTransaction().commit();
		
		EntityManager em = newEntityManager();
		em.getTransaction().begin();
		Child child2 = em.find(Child.class, child.getId());
		child2.setAge(2);
		em.getTransaction().commit();
		
		Child child3 = masterEM
				.createQuery("from Child where id=:id", Child.class)
				.setParameter("id", child.getId())
				.getSingleResult();
		
		Assertions.assertEquals(2, child2.getAge());
		Assertions.assertEquals(1, child3.getAge());
	}
	
//	@Test
	public void hqlQueryWithRefresh() throws InterruptedException {
		
		Child child = new Child()
				.setName("child x")
				.setAge(1);
		
		masterEM.getTransaction().begin();
		masterEM.persist(child);
		masterEM.getTransaction().commit();
		
		EntityManager em = newEntityManager();
		em.getTransaction().begin();
		Child child2 = em.find(Child.class, child.getId());
		child2.setAge(2);
		em.getTransaction().commit();
		
		Child child3 = masterEM
				.createQuery("from Child where id=:id", Child.class)
				.setParameter("id", child.getId())
				.getSingleResult();
		
		Assertions.assertEquals(2, child2.getAge());
		Assertions.assertEquals(1, child3.getAge());
		
		masterEM.refresh(child3);
		Assertions.assertEquals(2, child3.getAge());
	}
	
	@Test
	@Disabled
	public void sqlQueryUsesFirstLevelCache() {
	
		Child child = new Child()
				.setName("child 2")
				.setAge(11);
		
		masterEM.getTransaction().begin();
		masterEM.persist(child);
		masterEM.getTransaction().commit();
		
		EntityManager em = newEntityManager();
		em.getTransaction().begin();
		Child child2 = em.find(Child.class, child.getId());
		child2.setAge(22);
		em.getTransaction().commit();
		
		Object age = masterEM
				.createNativeQuery("select age as age from child where id=:id")
				.setParameter("id", child.getId())
				.getSingleResult();
		
		Assertions.assertEquals(22, child2.getAge());
		Assertions.assertEquals(22, (Integer) age);
	}
}
