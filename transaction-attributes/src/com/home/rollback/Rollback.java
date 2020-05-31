package com.home.rollback;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.home.model.ParentAssignedId;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Rollback {

	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@Resource
	private EJBContext ejbContext;
	
	public void rollback() {
		em.persist(new ParentAssignedId(500));
		ejbContext.setRollbackOnly();
	}

	public void select() {
		System.out.println(em.find(ParentAssignedId.class, 500));
	}
}