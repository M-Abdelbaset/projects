package com.home.trxattributes.requiresnew2;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService1 {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(value = TxType.REQUIRED)
	public void persist() {
		Session session = sessionFactory.getCurrentSession();
		session.persist(new SpringCustomer());
	}
}
