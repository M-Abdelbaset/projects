package com.home.rs;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.home.model.Parent;

@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Statefulbean {
	
	@PersistenceContext(
			type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	private List<Parent> parents;
	
	@PostConstruct
	private void init() {
		parents = new ArrayList<>();
	}
	
	public List<Parent> save(String name) {
		Parent parent = new Parent(name);
		
		em.persist(parent);
		
		parents.add(parent);
		return parents;
	}
	
	public Parent update(Integer id, String newName) {
		Parent target = em.find(Parent.class, id); // runs in a separate JTA transaction, hence triggers a select statement
		target.setName(newName); // triggers an update statement
		return target;
	}
	
	private boolean testEntityState() {
		if(em != null)
			return em.isOpen();
		else 
			return false;
	}
	
	@Remove
	public void remove() {
		System.out.println("Entity manager open: " + testEntityState());
		System.out.println("Removing stateful EJB ...");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Entity manager open: " + testEntityState());
	}
}
