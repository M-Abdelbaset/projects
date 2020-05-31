package com.home.dao;

import java.util.List;

import com.home.entity.Customer;

public interface CustomerDao {

	void saveCustomer(Customer customer);
	List<Customer> getCustomers();
	Customer getCustomer(String email);
	void updateCustomer(Customer customer);
	void deleteCustomer(String email);
}
