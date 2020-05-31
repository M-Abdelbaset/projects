package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Book;
import model.Bus;
import model.Laptop;
import model.Student;

public class SampleTest {

	private static SessionFactory sf;
	private static final int TEST_ID = 10;
	
	@BeforeAll
	public static void init() {
		Configuration cfg = new Configuration();
		sf = cfg.configure("hibernate-test.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Bus.class)
				.buildSessionFactory();
	}
	
	@Test
	public void addStudent() {
		Session s = null;
		
		try {
			s = sf.openSession();
			s.getTransaction().begin();

			s.persist(new Student(null, TEST_ID));

			s.getTransaction().commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			if(s != null && s.getTransaction().isActive()) {
				s.getTransaction().rollback();
			}
		} finally {
			if(s != null)
				s.close();
		}
		
		/**************************************************/
		
		Student savedStd = null;
		try {
			
			s = sf.openSession();
			s.getTransaction().begin();

			savedStd = s.get(Student.class, TEST_ID);
			if(savedStd != null) {
				System.out.println("Found student with id: " + TEST_ID);
				s.remove(savedStd);
			}
			
			s.getTransaction().commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			if(s != null && s.getTransaction().isActive()) {
				s.getTransaction().rollback();
			}
		} finally {
			if(s != null) {
				s.close();
			}
		}
	}
	
	@AfterAll
	static void clean() {
		sf.close();
	}
	
}
