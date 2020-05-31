package com.test.cascade.onetoone;

import java.util.Properties;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.AbstractJPATest;

public class OneToOne extends AbstractJPATest {

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
	/*	Parent p = new Parent();
		p.setName("paren 1");
		
		Child c = new Child();
		c.setName("child 1");
		
		p.addChild(c);
		
		masterEM.getTransaction().begin();
		masterEM.persist(p);
		masterEM.getTransaction().commit();*/
		
		masterEM.getTransaction().begin();
		
		Parent p = new Parent();
		p.setName("paren 1");
		masterEM.persist(p);
		
		Child c = new Child();
		c.setName("child 1");
		c.setParent(p);
		masterEM.persist(c);
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void removeChildFromParentWithNoOrphanRemoval() {
		masterEM.getTransaction().begin();
		
		Parent p = masterEM.find(Parent.class, 3);
		p.removeChild(); // if orphan removal is false, this will only work if 
		//there is a separate column for foreign key, because otherwise, this means deleting the record.
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void removeChildFromParentWithOrphanRemoval() {
		masterEM.getTransaction().begin();
		
		Parent p = masterEM.find(Parent.class, 3);
		p.removeChild(); // if orphan removal is true, this will work 
		// even when sharing the same column, because deleting the child record is allowed.
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void removeParentFromChild() {
		masterEM.getTransaction().begin();
		
		Child c = masterEM.find(Child.class, 3);
		c.setParent(null); // will work. Will set FK to null. Will not trigger child deletion!(I cannot delete myself)
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void removeParent() {
		masterEM.getTransaction().begin();
		
		Parent p = masterEM.find(Parent.class, 2);
		masterEM.remove(p);
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void merge() {
		masterEM.getTransaction().begin();
		
		Parent p = masterEM.find(Parent.class, 3);
		
		masterEM.detach(p);
		
		p.setName("new parent name " + UUID.randomUUID());
		p.getChild().setName("new child name " + UUID.randomUUID());
		masterEM.merge(p);
		
		masterEM.getTransaction().commit();
	}
	
	@Test
//	@Disabled
	public void findParent() {
		//Parent parent = masterEM.find(Parent.class, 1);
		Parent parent = masterEM.createQuery("from Parent p"
				+ " join fetch p.child"
				+ " where p.id=:id", Parent.class)
				.setParameter("id", 1)
				.getSingleResult();
	}
	
	@Test
	@Disabled
	public void findChild() {
		Child child = masterEM.find(Child.class, 1);
	}
}
