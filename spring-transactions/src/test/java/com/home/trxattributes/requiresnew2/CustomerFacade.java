package com.home.trxattributes.requiresnew2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerFacade {
	
	@Autowired
	private CustomerService1 customerService1;
	@Autowired
	private CustomerService2 customerService2;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = NullPointerException.class)	
	public void persistv2() {
		SpringCustomer springCustomer = new SpringCustomer();
		springCustomer.setName("");
		em.persist(springCustomer);
		customerService2.rollback();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public long count() {
		return em.createQuery("select count(*) from SpringCustomer", Long.class).getSingleResult();
	}
}
