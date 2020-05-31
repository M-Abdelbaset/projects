package com.home.transactionattribute.mandatory;

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
public class TransactionalBeanA_4 {

	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@EJB
	private BeanB_4 beanB;
	
	public void call_joinTransaction() {
		ParentAssignedId parent = new ParentAssignedId(333);
		em.persist(parent); // triggers an insert
		beanB.joinTransaction();
	}
}
