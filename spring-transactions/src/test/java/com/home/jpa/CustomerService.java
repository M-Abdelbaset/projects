package com.home.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void find() {
		em.find(SpringCustomer.class, 1);
	}
}
