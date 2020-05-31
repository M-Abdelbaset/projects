package com.home.transactionattribute.notsupported;

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
public class TransactionalBeanA_5 {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@EJB
	private BeanB_5 beanB;

	public void call_suspendTransaction() {
		ParentAssignedId parent = new ParentAssignedId(400);
		em.persist(parent); // triggers an insert
		try {
			beanB.suspendTransaction();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}
