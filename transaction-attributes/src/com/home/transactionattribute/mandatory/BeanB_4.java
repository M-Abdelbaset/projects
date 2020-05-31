package com.home.transactionattribute.mandatory;

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
public class BeanB_4 {

	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	/**
	 * Join the caller transaction.
	 */
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void joinTransaction() {
		System.out.println("calling joinTransaction ...");
		em.find(ParentAssignedId.class, 333); // will not trigger a select
	}
}
