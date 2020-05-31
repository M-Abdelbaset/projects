package com.home.trxattributes.requiresnew;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerFacade {
	
	@Autowired
	private CustomerService1 customerService1;
	@Autowired
	private CustomerService2 customerService2;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(value = TxType.REQUIRED)
	public void persist() {
		customerService1.persist();
		customerService2.rollback();
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void persistv2() {
		Session session = sessionFactory.getCurrentSession();
		session.persist(new SpringCustomer());
		customerService2.rollback();
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void persistv3() {
		Session session = sessionFactory.getCurrentSession();
		session.persist(new SpringCustomer());
		customerService2.rollback();
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void persistv4() {
		Session session = sessionFactory.getCurrentSession();
		session.persist(new SpringCustomer());
		throw new NullPointerException();
	}
	
	@Transactional(value = TxType.REQUIRED)
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select count(*) from SpringCustomer", Long.class).getSingleResult();
	}
}
