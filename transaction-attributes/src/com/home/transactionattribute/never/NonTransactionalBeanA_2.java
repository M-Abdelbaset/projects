package com.home.transactionattribute.never;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class NonTransactionalBeanA_2 {

	@EJB
	private BeanB_2 bean;
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void runOusideTransaction() {
		System.out.println("calling runOusideTransaction ... ");
		bean.runOusideTransaction();
	}
}
