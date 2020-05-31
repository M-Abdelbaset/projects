package com.home.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Customer getCustomer(String email) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session
				.byNaturalId(Customer.class)
				.using("email", email)
				.load();
		
		return customer;
	}
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Customer", Customer.class).getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(customer);
	}
	
	@Override
	public void updateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(customer);
	}

	@Override
	public void deleteCustomer(String email) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Customer where email=:email")
				.setParameter("email", email)
				.executeUpdate();
	}
}
