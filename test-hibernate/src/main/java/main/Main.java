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

public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student(new Name("fname", "lname"), 1);
		
		Bus bus = new Bus(1, "haram", null);
		s1.setBus(bus);
		
		Book book1 = new Book(1, 1, null);
		s1.getBooks().add(book1);
		
		Configuration cfg = 
				new Configuration()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Bus.class)
				.addAnnotatedClass(Book.class)
				.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = null; // persistence context
		s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(book1);
		s.save(s1);
		s.save(bus);
		tx.commit();
		//s.close();
		
		
		s = sf.openSession();
		tx = s.beginTransaction();
		System.out.println("getting student");
		Student res = s.get(Student.class, 1);
		System.out.println("printing data");
		System.out.println(res.getName());
		System.out.println(res.getBus().getRoute());
		System.out.println(res.getBooks());
		tx.commit();
		s.close();
		
	}
}
