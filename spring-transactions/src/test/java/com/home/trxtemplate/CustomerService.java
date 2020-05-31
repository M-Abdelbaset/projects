package com.home.trxtemplate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class CustomerService {

	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist() {
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				sessionFactory.getCurrentSession().persist(new SpringCustomer());
			}
		});
	}
}
