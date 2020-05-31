package com.test.jpql;

import java.util.Properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.AbstractJPATest;
import com.test.cascade.onetomany.Child;
import com.test.cascade.onetomany.Parent;

public class JoinVsJoinFetchUnitTest extends AbstractJPATest {

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
	public void persistAll() {
		Parent p1 = new Parent();
		p1.setName("parent #1");
		
		Child c1 = new Child();
		c1.setName("child #1");
		
		Child c2 = new Child();
		c1.setName("child #2");
		
		p1.addChild(c1);
		p1.addChild(c2);
		
		masterEM.getTransaction().begin();
		masterEM.persist(p1);
		masterEM.getTransaction().commit();
	}
	
	@Test
	public void testJoinFetch() {
		System.out.println("join fetch");
		System.out.println(masterEM.createQuery(
				  "select p from Parent p "
				+ "join fetch p.children "
				+ "where p.id=:parentId", Parent.class)
				.setParameter("parentId", 1)
				.getSingleResult());
	}
	
	@Test
	public void testJoin() {
		System.out.println("join");
		System.out.println(masterEM.createQuery(
				  "select p from Parent p "
				+ "join p.children "
				+ "where p.id=:parentId", Parent.class)
				.setParameter("parentId", 1)
				.getSingleResult());
	}
	
	@Test
	public void testJoin2() {
		System.out.println("join 2");
		System.out.println(masterEM.createQuery(
				  "select p from Parent p "
				+ "join Child c "
				+ "on p.id = c.parent "	  
				+ "where p.id=:parentId", Parent.class)
				.setParameter("parentId", 1)
				.getSingleResult());
	}
	
	@Test
	public void testJoin3() {
		System.out.println("join 3");
		System.out.println(masterEM.createQuery(
				  "select p,c from Parent p "
				+ "join Child c "
				+ "on p.id = c.parent "	  
				+ "where p.id=:parentId")
				.setParameter("parentId", 1)
				.getResultList());
	}
}
