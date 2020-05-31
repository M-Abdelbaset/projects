package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Book;
import model.Bus;
import model.Laptop;
import model.Student;

public class FirstLevelCache {

	public static void main(String[] args) {
		
		Configuration cfg = 
				new Configuration()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Bus.class)
				.addAnnotatedClass(Book.class)
				.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query<Student> q = session.createQuery("from Student where id=1", Student.class)
				.setCacheable(true);
		
		Student s1 = null;
		s1 = (Student) q.getSingleResult();
		s1 = (Student) q.getSingleResult();
		//s1 = session.get(Student.class, 1);		
		//s1 = session.get(Student.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		/****************************/
		// another session:
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		q = session2.createQuery("from Student where id=1", Student.class)
				.setCacheable(true);
		
		s1 = (Student) q.getSingleResult();
		s1 = (Student) q.getSingleResult();
		
		//s1 = session2.get(Student.class, 1);		
		//s1 = session2.get(Student.class, 1);
		
		session2.getTransaction().commit();
		session2.close();
		
		sf.close();
	}
}
