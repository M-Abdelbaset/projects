package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.Book;
import model.Bus;
import model.Laptop;
import model.Name;
import model.Student;

public class States {

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
		
		Student s = new Student();
		s.setId(8);
		
		session.save(s);
		s.setName(new Name("2nd", "2nd"));
		s.setName(new Name("3rd", "3rd"));
		session.getTransaction().commit();
		
		session.beginTransaction();
		s = session.get(Student.class, 8);
	//	session.detach(s);
	//	session.evict(s);
		s.setName(new Name("4th", "4th"));
		session.getTransaction().commit();

		session.close();
		sf.close();
	}
}
