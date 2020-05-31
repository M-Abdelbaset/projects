package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import model.Book;
import model.Bus;
import model.Laptop;
import model.Student;

public class HQL {

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
		
		Query<Student> q = session.createQuery("from Student s where s.bus.id=?1", Student.class);
		q.setParameter(1, 1);
		
		NativeQuery<Student> sql = session.createSQLQuery("");
		
		Student s1 = (Student) q.getSingleResult();
		System.out.println(s1);
		session.getTransaction().commit();
		
		session.close();
		sf.close();
	}
}
