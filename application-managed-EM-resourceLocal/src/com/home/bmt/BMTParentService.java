package com.home.bmt;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import com.home.model.Parent;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BMTParentService {
 
//	@PersistenceContext
//	private EntityManager em; 
	// not allowed: 
	// WFLYJPA0021: Cannot inject RESOURCE_LOCAL container managed EntityManagers 
	// using @PersistenceContext
	
//	@Resource
//	private UserTransaction trx;
	// Only session and message-driven beans with bean-managed transaction 
	// demarcation are allowed to access UserTransaction
	
	@PersistenceUnit(unitName = "rl")
	private EntityManagerFactory emf;
	
	public void save() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		
		trx.begin();
		Parent parent = new Parent("one");
		em.persist(parent);
		trx.commit();
		
		em.close();
	}

	
	public void PCOpenTillEMClosed() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		Parent parent1 = new Parent("one");
		trx.begin();
		em.persist(parent1);
		System.out.println("First Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, parent1.getId()); // no select since the JTA trx is active
		trx.commit();
		
		/////////////////////////
		
		System.out.println("Second Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, parent1.getId()); // a new transaction is use, new PC is created
		
		/////////////////////////
	
		Parent parent2 = new Parent("two");
		trx.begin();
		System.out.println("Third Trx contains parent1? " + em.contains(parent1));
		em.persist(parent2);
		trx.commit();
		
		em.close();
	}
	
	public void PCOpenTillEMClosed2() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		Parent parent1 = new Parent("one");
		trx.begin();
		em.persist(parent1);
		System.out.println("First Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, parent1.getId()); // no select since the JTA trx is active
		trx.commit();
		em.close();
		/////////////////////////
		
		em = emf.createEntityManager();
		System.out.println("Second Trx contains parent1? " + em.contains(parent1));
		em.find(Parent.class, parent1.getId()); // a new transaction is use, new PC is created
		em.close();
		/////////////////////////
	
		Parent parent2 = new Parent("two");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Third Trx contains parent1? " + em.contains(parent1));
		em.persist(parent2);
		em.getTransaction().commit();
		em.close();
	}
}
