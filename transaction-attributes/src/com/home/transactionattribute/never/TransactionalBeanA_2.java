package com.home.transactionattribute.never;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.home.model.ParentAssignedId;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TransactionalBeanA_2 {

	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@EJB
	private BeanB_2 beanB;
	
	public void call_dontJoinTransaction() {
		ParentAssignedId parent = new ParentAssignedId(88);
		em.persist(parent); // triggers an insert
		
		try {
			beanB.dontJoinTransaction();
		} catch (Exception e) {
			System.out.println("Failed ...");
		}
	}
}
