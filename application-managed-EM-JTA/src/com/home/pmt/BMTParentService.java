package com.home.pmt;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

import com.home.model.Parent;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BMTParentService {
 
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Resource
	private UserTransaction trx;
	
	public void whenCreatingEMWithinActiveUserTrx_thenSave() throws Exception {
		trx.begin();
		EntityManager em = emf.createEntityManager();
		Parent parent = new Parent("one");
		em.persist(parent);
		trx.commit();
		em.close();
	}
	
	public void whenCreatingEMNoActiveUserTrx_thenNothing() throws Exception {
		EntityManager em = emf.createEntityManager();
		Parent parent = new Parent("one");
		em.persist(parent);
		em.close();
	}
	
	public void whenCreatingEMOutsideActiveUserTrx_thenNothing() throws Exception {
		EntityManager em = emf.createEntityManager();
		trx.begin();
		Parent parent = new Parent("one");
		em.persist(parent);
		trx.commit();
		em.close();
	}
	
	public void whenCreatingEMOutsideActiveUserTrx_thenJoin() throws Exception {
		EntityManager em = emf.createEntityManager();
		trx.begin();
		em.joinTransaction(); // join the previous transaction
		Parent parent = new Parent("one");
		em.persist(parent);
		trx.commit();
		em.close();
	}
	
	/**
	 * throws: Transaction is not accessible when using 
	 * JTA with JPA-compliant transaction access enabled
	 */
	public void whenUsingEntityTransaction_methodWillFail() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction();
		em.close();
	}
	
	public void appManagedEMScopeIsTillClosed() throws Exception {
		trx.begin();
		EntityManager em = emf.createEntityManager();
		Parent parent1 = new Parent("one");
		em.persist(parent1);
		System.out.println("First Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, parent1.getId()); // no select since the JTA trx is active
		trx.commit();
		
		/////////////////////////
		
		System.out.println("Second Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, parent1.getId()); // a new transaction is use, new PC is created
		
		/////////////////////////
	
		trx.begin();
		Parent parent2 = new Parent("two");
		System.out.println("Third Trx contains parent1? " + em.contains(parent1));
		em.persist(parent2);
		trx.commit();
		
		em.close();
	}
	
	public void appManagedEMScopes() throws Exception {
		trx.begin();
		EntityManager em = emf.createEntityManager();
		Parent parent1 = new Parent("one");
		em.persist(parent1);
		System.out.println("First Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, parent1.getId()); // no select since the JTA trx is active
		trx.commit();
		em.close();
		/////////////////////////
		
		em = emf.createEntityManager();
		System.out.println("Second Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, parent1.getId()); // a new EM, a new PC is created
		
		/////////////////////////
	
		em = emf.createEntityManager();
		trx.begin();
		Parent parent2 = new Parent("two");
		System.out.println("Third Trx contains parent1? " + em.contains(parent1));
		em.persist(parent2);
		trx.commit();
		em.close();
	}
}
