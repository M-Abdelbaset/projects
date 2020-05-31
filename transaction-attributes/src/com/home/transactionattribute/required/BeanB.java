package com.home.transactionattribute.required;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.home.model.ParentAssignedId;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BeanB {

	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	/**
	 * starts a new transaction
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save() {
		System.out.println("calling save ... ");
		ParentAssignedId parent = em.find(ParentAssignedId.class, 55); //triggers a select
		parent = new ParentAssignedId(55);
		em.persist(parent); // triggers an insert
	}
	
	/**
	 * runs within the caller's transaction.
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void joinTransaction() {
		System.out.println("calling join ... ");
		ParentAssignedId parent = em.find(ParentAssignedId.class, 88); // since this joins
		// the caller's transaction, no select is issued.
		parent.setName("new name"); // update
	}
	
	/**
	 * No DML statement will be executed, wither 
	 * of this method or the caller
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void rollback() {
		System.out.println("calling rollback ... ");
		throw new RuntimeException();
	}
}
