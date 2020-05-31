package com.home.transactionattribute.requiresnew;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.home.model.Parent;
import com.home.model.ParentAssignedId;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BeanB_3 {

	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	/**
	 * starts a new transaction
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void save() {
		System.out.println("calling save ... ");
		Parent p = new Parent("save");
		em.persist(p);
	}
	
	/**
	 * suspends the caller's transaction and starts a new one.
	 * The PC is not shared then.
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void startNewTransaction() {
		System.out.println("calling startNewTransaction ...");
		em.find(ParentAssignedId.class, 111); // triggers a select
	}
	
	/**
	 * No DML statement will be executed. The caller transaction succeeds
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void rollback() {
		System.out.println("calling rollback ... ");
		throw new RuntimeException();
	}
}
