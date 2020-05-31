package com.home.exceptiontranslation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Component
@Repository
public class CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist() {
		SpringCustomer springCustomer = new SpringCustomer();
		sessionFactory.getCurrentSession().persist(springCustomer);
	}
}
