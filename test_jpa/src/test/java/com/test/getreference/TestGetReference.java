package com.test.getreference;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;

import org.hibernate.Hibernate;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.AbstractJPATest;

public class TestGetReference extends AbstractJPATest{

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Student.class, Book.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	@Test
	@Disabled
	public void testPersist() {
		
		doInTransaction(masterEM, () -> {
			
			Student student = new Student("std 1");
			student.setId(1);
			
			Book book = new Book("book # 1");
			book.setStudent(student);
			masterEM.persist(book);
		});
	}
	
	@Test
//	@Disabled
	public void testPersistWithGetReference() {
		
		doInTransaction(masterEM, () -> {
			
			Student student = masterEM.getReference(Student.class, 78);
			
			Book book = new Book("book 1");
			book.setStudent(student);
			
			masterEM.persist(book);
		});
	}
	
	@Test
	@Disabled
	public void lazyInitException() {
		
		Student student = masterEM.getReference(Student.class, 1);
		System.out.println("Got reference!: " + student.getClass().getName());
		masterEM.close();
		
		try {
			// the original EM must be open!
			EntityManager em = newEntityManager();
			em.getTransaction().begin();
			System.out.println(student.getName());
			em.getTransaction().commit();
		} catch (LazyInitializationException e) {
			System.out.println("LazyInitializationException!");
		}
	}
	
	@Test
	public void unproxy() {
		
		Student student = masterEM.getReference(Student.class, 2);
		System.out.println("Got reference!: " + student.getClass().getName());
		student = Hibernate.unproxy(student, Student.class);
		System.out.println("Un proxied!: " + student.getClass().getName());
		System.out.println(student);
	}
	
	@Test
	@Disabled
	public void getSome() {
		Tuple data = masterEM
				.createQuery("select id as id, name as name from Student where id=:id", Tuple.class)
				.setParameter("id", 1)
				.getSingleResult();
		System.out.println(data.get("name"));
	}
}
