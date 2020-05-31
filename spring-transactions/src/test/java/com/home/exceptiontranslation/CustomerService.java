package com.home.exceptiontranslation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public void save() {
		try {
			customerDao.persist();
		} catch(DataAccessException ex) {
			System.out.println("cought a DataAccessException");
			System.out.println(ex);
		} catch(Exception ex) {
			System.out.println("cought an Exception");
			System.out.println(ex);
		}
	}
}
