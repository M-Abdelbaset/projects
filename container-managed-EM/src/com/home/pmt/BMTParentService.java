package com.home.pmt;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import com.home.model.Parent;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BMTParentService {
 
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction trx;
	
	/**
	 * throws: Transaction is required to perform this operation 
	 * (either use a transaction or extended persistence context)
	 */
	public void whenSavingWithoutTrx_exceptionIsThrown() {
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
		trx.begin();
		em.persist(parent);
		trx.commit();
	}
	
	public void whenUsingUserTransaction_thenSave() throws Exception {
		Parent parent = new Parent("one");
		trx.begin();
		em.persist(parent);
		trx.commit();
	}
	
	public void whenUsingUserTransaction_thenMultipleSave() throws Exception {
		Parent parent1 = new Parent("one");
		trx.begin();
		em.persist(parent1);
		System.out.println("First Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, 1); // no select since the JTA trx is active
		trx.commit();
		
		/////////////////////////
		
		System.out.println("Second Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, 1); // a new transaction is use, new PC is created
		
		/////////////////////////
	
		Parent parent2 = new Parent("two");
		trx.begin();
		System.out.println("Third Trx contains parent1? " + em.contains(parent1));
		em.persist(parent2);
		trx.commit();
	}
	
	/**
	 * throws WFLYJPA0017: Container managed entity manager can only be closed by the container 
	 * (auto-cleared at tx/invocation end and closed when owning component is closed.)
	 */
	public void whenClosingEM_thenMethodFails() throws Exception {
		Parent parent = new Parent("one");
		trx.begin();
		em.persist(parent);
		trx.commit();
		em.close();
	}
}
