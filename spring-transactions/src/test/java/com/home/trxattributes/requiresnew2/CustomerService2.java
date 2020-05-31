package com.home.trxattributes.requiresnew2;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService2 {
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = NullPointerException.class)
	public void rollback() {
		throw new NullPointerException();
	}
}
