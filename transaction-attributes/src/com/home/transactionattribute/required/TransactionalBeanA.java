package com.home.transactionattribute.required;

import javax.ejb.EJB;
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
public class TransactionalBeanA {

	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@EJB
	private BeanB beanB;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void call_joinTransaction() {
		ParentAssignedId parent = new ParentAssignedId(88);
		em.persist(parent); // triggers an insert
		beanB.joinTransaction();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void call_rollback() {
		ParentAssignedId parent = new ParentAssignedId(77);
		em.persist(parent); // will not execute
		try {
			beanB.rollback();
		}catch (Exception e) {
			System.out.println("RTE ... ");
		}
	}
}
