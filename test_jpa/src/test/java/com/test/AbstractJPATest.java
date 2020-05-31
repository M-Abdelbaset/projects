package com.test;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.test.util.JpaEntityManagerFactory;

@SuppressWarnings("rawtypes")
public class AbstractJPATest {

	private JpaEntityManagerFactory emf;
	protected EntityManager masterEM;
	private Class[] classes;
	private Properties props;
	private Set<EntityManager> externalEM = new HashSet<>();
	
	protected Properties getProperties() {
		return new Properties();
	}
	
	protected Class[] getClasses() {
		return new Class[] {};
	}
	
	@BeforeEach
	protected void init() {
		this.classes = getClasses();
		this.props = getProperties();
		System.out.println("Creating an EM ... \n");
		emf = new JpaEntityManagerFactory(classes, props);
		masterEM = emf.getEntityManager();
	}
	
	protected EntityManager newEntityManager() {
		System.out.println("Creating a slave EM ...");
		EntityManager em = emf.getEntityManager();
		externalEM.add(em);
		return em;
	}
	
	@AfterEach
	protected void cleanUp() {
		
		System.out.println();
		for(EntityManager em : externalEM) {
			System.out.println("Closing slave ...");
			if(em != null && em.isOpen())
				em.close();
		}
		
		System.out.println("Closing master ...");
		if(masterEM != null && masterEM.isOpen())
			masterEM.close();
	}
	
	protected void doInTransaction(EntityManager em, DoInTransaction doInTransaction) {
		em.getTransaction().begin();
		doInTransaction.execute();
		em.getTransaction().commit();
	}
}
