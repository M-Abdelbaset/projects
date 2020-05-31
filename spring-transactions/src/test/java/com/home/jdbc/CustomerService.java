package com.home.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public void save() {
		customerDao.persist();
	}
}
