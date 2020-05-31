package com.home.cmt;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

import com.home.model.Parent;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CMTParentService {
 
	@PersistenceUnit
	private EntityManagerFactory emf;
	
//	@Resource
//	private UserTransaction trx;
//  Only session and message-driven beans 
//	with bean-managed transaction demarcation are allowed to access UserTransaction
	
	/**
	 * The EM is created within an active JTA transaction
	 */
	public void save() {
		EntityManager em = emf.createEntityManager();
		Parent parent = new Parent("one");
		em.persist(parent);
		em.close();
	}
	
	/**
	 * throws: Transaction is not accessible when using 
	 * JTA with JPA-compliant transaction access enabled
	 */
	public void whenUsingEntityTransaction_methodWillFail() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction();
	}
}
