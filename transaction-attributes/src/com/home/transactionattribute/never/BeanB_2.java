package com.home.transactionattribute.never;

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
public class BeanB_2 {

	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void runOusideTransaction() {
		em.find(ParentAssignedId.class, 55); // a select does not require a transaction
		
		try {
			em.persist(new ParentAssignedId(707)); // throws an exception as a transaction is required!
		} catch (TransactionRequiredException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("end calling runOusideTransaction ... ");
	}
	/**
	 * throws exception
	 */
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void dontJoinTransaction() {
		System.out.println("calling dontJoinTransaction ... ");
	}
}
