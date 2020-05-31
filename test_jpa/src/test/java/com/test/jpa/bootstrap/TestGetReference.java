package com.test.jpa.bootstrap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.Test;

public class TestGetReference {

	@Test
	public void test() {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("puf");
		
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Student student = new Student("std 1");
		student.setId(1);
		
		Book book = new Book("book # 1");
		book.setStudent(student);
		
		entityManager.persist(book);
		
		entityManager.getTransaction().commit();
	}
}
