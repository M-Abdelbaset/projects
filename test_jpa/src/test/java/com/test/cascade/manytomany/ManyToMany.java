package com.test.cascade.manytomany;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.hibernate.Session;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.AbstractJPATest;

public class ManyToMany extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Parent.class, Child.class};
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
//		for(int i = 0; i < 5; i++) {
		Parent p1 = new Parent();
		p1.setName("parent 1");

		Child c1 = new Child();
		c1.setName("child " + UUID.randomUUID());
		Child c2 = new Child();
		c2.setName("child "+ UUID.randomUUID());
		
		p1.addChild(c1); p1.addChild(c2);
		
		Parent p2 = new Parent();
		p2.setName("parent 2");
		
		Child c3 = new Child();
		c3.setName("child " + UUID.randomUUID());
		
		p2.addChild(c3);
		
		masterEM.getTransaction().begin();
		masterEM.persist(p1);
		masterEM.persist(p2);
		masterEM.getTransaction().commit();
//		}
	}
	
	@Test
	@Disabled
	public void removeChildFromParent() {
		masterEM.getTransaction().begin();
		
		Parent p = masterEM.createQuery("select p from Parent p"
				+ " join fetch p.children"
				+ " where p.id = :id", Parent.class)
				.setParameter("id", 1)
				.getSingleResult();
		Child c = masterEM.unwrap(Session.class)
				.bySimpleNaturalId(Child.class)
				.load("child 3b151266-b41b-447c-9fef-0d53f38c7664");
		
		p.removeChild(c); // Will remove the relation DB record
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void removeParent() {
		masterEM.getTransaction().begin();
		
		//Parent p = em.find(Parent.class, 1);

		Parent p = masterEM.createQuery("select p from Parent p" // creates only one select
				+ " join fetch p.children" + " where p.id = :id", Parent.class).setParameter("id", 1).getSingleResult();
		p.removeChildren();
		masterEM.remove(p);
		
		masterEM.getTransaction().commit();
	}

	@Test
	@Disabled
	public void removeParentWithRemoveCascade() {
		masterEM.getTransaction().begin();
		
		//Parent p = em.find(Parent.class, 1);

		Parent p = masterEM.createQuery("select p from Parent p" // creates only one select
				+ " join fetch p.children" + " where p.id = :id", Parent.class)
				.setParameter("id", 5).getSingleResult();
		masterEM.remove(p);
		
		masterEM.getTransaction().commit();
	}

	@Test
	@Disabled
	public void removeParentWithRemoveCascadeOnBothSides() {
		masterEM.getTransaction().begin();
		
		//Parent p = em.find(Parent.class, 1);
		
		Parent p = masterEM.createQuery("select p from Parent p" // creates only one select
				+ " join fetch p.children" + " where p.id = :id", Parent.class)
				.setParameter("id", 9).getSingleResult();
		masterEM.remove(p);
		
		masterEM.getTransaction().commit();
	}

	@Test
	@Disabled
	public void merge() {
		masterEM.getTransaction().begin();
		
		Parent p = masterEM.createQuery("select p from Parent p"
				+ " join fetch p.children"
				+ " where p.id = :id", Parent.class)
				.setParameter("id", 1)
				.getSingleResult();
		
		p.setName("new parent name " + UUID.randomUUID());
		Iterator<Child> it = p.getChildren().iterator();
		while(it.hasNext()) {
			Child c = it.next();
			c.setAge(UUID.randomUUID().hashCode());
		}
		
		masterEM.merge(p);
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	public void test() {
		
		Set<String> names = new HashSet<String>();
		names.add("one"); 
		names.add("two");
		System.out.println(names.size());
		
		for(String name : new HashSet<String>(names)) {
			names.remove(name);
		}
		
		System.out.println(names.size());
	}
}
