package com.home.trxlistener;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class CustomerService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Transactional
	public void persist() {
		SpringCustomer springCustomer = new SpringCustomer();
		sessionFactory.getCurrentSession().persist(springCustomer);
		applicationEventPublisher.publishEvent(springCustomer);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void rollback() {
		SpringCustomer springCustomer = new SpringCustomer();
		sessionFactory.getCurrentSession().persist(springCustomer);
		applicationEventPublisher.publishEvent(springCustomer);
		throw new NullPointerException();
	}
	
	@TransactionalEventListener
	public void saveEvent(SpringCustomer springCustomer) {
		System.out.println("Customer created: " + springCustomer.getId());
	}
	
	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
	public void rollbackEvent(SpringCustomer springCustomer) {
		System.out.println("Customer rolledback: " + springCustomer.getId());
	}
}
