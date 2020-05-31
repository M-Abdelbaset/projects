package com.home.transactionattribute.mandatory;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class NonTransactionalBeanA_4 {

	//@EJB
	//private BeanB_4 beanB;

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void save() {
		
	}
}
