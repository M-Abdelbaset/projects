package com.home.transactionattribute.requiresnew;

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
public class TransactionalBeanA_3 {
	
	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@EJB
	private BeanB_3 beanB;
	
	public void call_startNewTransaction() {
		ParentAssignedId parent = new ParentAssignedId(111);
		em.persist(parent); // triggers an insert
		beanB.startNewTransaction();
	}
	
	public void call_rollback() {
		ParentAssignedId parent = new ParentAssignedId(175);
		em.persist(parent); // triggers an insert
		try {
			beanB.rollback();
		}catch(Exception ex) {
			System.out.println("RTE ... ");
		}
	}
}
