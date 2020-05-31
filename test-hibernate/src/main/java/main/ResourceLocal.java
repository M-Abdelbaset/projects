package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Book;
import model.Bus;
import model.Laptop;
import model.Name;
import model.Student;

public class ResourceLocal {

	public static void main(String[] args) {
		
		Configuration cfg = 
				new Configuration()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Bus.class)
				.addAnnotatedClass(Book.class)
				.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession(); // opens persistence context
		
		Student s1 = new Student(new Name("fname", "lname"), 1);
		
		Transaction tx = s.getTransaction();
		System.out.println("First trx: " + tx);
		
		tx.begin();
		s.persist(s1);
		s.getTransaction().commit();
		
		tx = s.getTransaction();
		System.out.println("Second trx: " + tx);
		s.getTransaction().begin();
		s.get(Student.class, 1);
		s.getTransaction().commit();
		
		// this operation is queued until a transaction is committed
		s1.setName(new Name("lname", "lname"));
		s.getTransaction().begin();
		s.getTransaction().commit();
		
		s.close();
		
		s = sf.openSession(); // opens another persistence context
		tx = s.getTransaction();
		System.out.println("Third trx: " + tx);
		s.getTransaction().begin();
		System.out.println(s.get(Student.class, 1));
		s.getTransaction().commit();
		
		s.close();
		sf.close();
	}
}
