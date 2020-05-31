package com.home.xmlconfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import lombok.Setter;

@Setter
public class CustomerService {

	private SessionFactory sessionFactory;
	
	public int getCustomersSize() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from SpringCustomer").getResultList().size();
	}
	
	public void getCustomersAndWrite() {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("from SpringCustomer").getResultList();
		session.persist(new SpringCustomer());
	}
	
	public void writeCustomer() {
		Session session = sessionFactory.getCurrentSession();
		session.persist(new SpringCustomer());
	}
	
	public void uncheckedRollsback() {
		Session session = sessionFactory.getCurrentSession();
		session.persist(new SpringCustomer());
		throw new RuntimeException();
	}
	
	public void checkedNotRollback() throws BusinessException {
		Session session = sessionFactory.getCurrentSession();
		session.persist(new SpringCustomer());
		throw new BusinessException();
	}
	
	public void checkedRollbackFor() throws BusinessException {
		Session session = sessionFactory.getCurrentSession();
		session.persist(new SpringCustomer());
		throw new BusinessException();
	}
	
	public void noRollback() {
		Session session = sessionFactory.getCurrentSession();
		session.persist(new SpringCustomer());
		throw new NullPointerException();
	}
	
	public void findAndPersist() {
		getCustomersAndWrite();
	}
}
