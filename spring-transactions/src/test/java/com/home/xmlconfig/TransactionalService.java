package com.home.xmlconfig;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class TransactionalService {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void getCustomersAndWrite() {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("from SpringCustomer").getResultList();
		session.persist(new SpringCustomer());
	}

	public void findAndPersist() {
		getCustomersAndWrite();
	}
}
