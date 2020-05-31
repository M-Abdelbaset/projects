package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.proxy.HibernateProxy;

import model.Book;
import model.Bus;
import model.Laptop;
import model.Student;

public class GetLoad {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Bus.class).addAnnotatedClass(Book.class).configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();

		HibernateProxy b = (HibernateProxy) session.load(Bus.class, 1);
		
		Student s = new Student();
		s.setId(12);
		s.setBus((Bus)b);
		session.save(s);
		
		session.getTransaction().commit();

		session.close();
		sf.close();
	}
}
