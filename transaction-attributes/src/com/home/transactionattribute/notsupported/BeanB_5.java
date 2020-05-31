package com.home.transactionattribute.notsupported;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TransactionRequiredException;

import com.home.model.ParentAssignedId;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BeanB_5 {

	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void runOutsideTrx() {
		em.find(ParentAssignedId.class, 55); // a select does not require a transaction
		
		try {
			em.persist(new ParentAssignedId(707)); // throws an exception as a transaction is required!
		} catch (TransactionRequiredException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("end calling runOusideTransaction ... ");
	}
	
	/**
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void suspendTransaction() {
		System.out.println("calling suspendTransaction ... ");
		em.find(ParentAssignedId.class, 400);
		throw new RuntimeException();
	}
}
