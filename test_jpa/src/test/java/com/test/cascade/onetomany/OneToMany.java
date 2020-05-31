package com.test.cascade.onetomany;

import java.util.Iterator;
import java.util.Properties;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.AbstractJPATest;

public class OneToMany extends AbstractJPATest {

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
//	@Disabled
	public void persist() {
		
		masterEM.getTransaction().begin();
		
		Parent p = new Parent();
		p.setName("paren 1");
		masterEM.persist(p);
		
		Child c1 = new Child();
		c1.setName("child " + UUID.randomUUID());
		c1.setParent(p);
		masterEM.persist(c1);
		
		Child c2 = new Child();
		c2.setName("child 4 "+ UUID.randomUUID());
		c1.setParent(p);
		masterEM.persist(c2);
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void removeChildFromParentWithNoOrphanRemoval() {
		masterEM.getTransaction().begin();
		
		Parent p = masterEM.createQuery("select p from Parent p"
				+ " join fetch p.children"
				+ " where p.id = :id", Parent.class)
				.setParameter("id", 4)
				.getSingleResult();
		Child c = new Child(); c.setName("child 4");
		
		p.removeChild(c); // Will set the FK to null
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void removeChildFromParentWithOrphanRemoval() {
		masterEM.getTransaction().begin();
		
		Parent p = masterEM.createQuery("select p from Parent p"
				+ " join fetch p.children"
				+ " where p.id = :id", Parent.class)
				.setParameter("id", 4)
				.getSingleResult();
		Child c = new Child(); c.setName("child 1");
		
		p.removeChild(c);
		
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
		
		//Parent p = em.find(Parent.class, 1); // creates 2 select queries
		Parent p = masterEM.createQuery("select p from Parent p" //creates only one select query
				+ " join fetch p.children"
				+ " where p.id = :id", Parent.class)
				.setParameter("id", 2)
				.getSingleResult();
		
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
}
