package com.home.cmt;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.home.model.Parent;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CMTParentService {
 
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction trx;
	
	public void save() {
		Parent parent = new Parent("one");
		em.persist(parent);
	}
	
	/**
	 * throws: Transaction is not accessible when using 
	 * JTA with JPA-compliant transaction access enabled
	 */
	public void whenUsingEntityTransaction_methodWillFail() {
		Parent parent = new Parent("one");
		EntityTransaction trx = em.getTransaction();
		em.persist(parent);
	}
	
	/**
	 * will throw: WFLYEJB0137: Only session and message-driven 
	 * beans with bean-managed transaction demarcation are allowed 
	 * to access UserTransaction
	 */
	public void whenUsingUserTransaction_methodWillFail() throws NotSupportedException, SystemException {
		Parent parent = new Parent("one");
		trx.begin();
		em.persist(parent);
		trx.begin();
	}
}
