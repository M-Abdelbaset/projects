package com.home.bmt.extended;

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
public class ExtendedBMTParentService {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	public void insideTrx() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		Parent p1 = new Parent("one");
		em.persist(p1);
		trx.commit();
		
		em.close();
	}
	
	public void joinTrx() {
		EntityManager em = emf.createEntityManager();
		Parent p1 = new Parent("one");
		em.persist(p1);
		
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		trx.commit();
		
		em.close();
	}
}
