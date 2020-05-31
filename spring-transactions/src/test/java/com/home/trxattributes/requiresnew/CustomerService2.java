package com.home.trxattributes.requiresnew;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

@Service
public class CustomerService2 {
	
	@Transactional(value = TxType.REQUIRED, rollbackOn = Exception.class)
	public void rollback() {
		throw new NullPointerException();
	}
}
