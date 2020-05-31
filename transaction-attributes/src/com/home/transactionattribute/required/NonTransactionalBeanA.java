package com.home.transactionattribute.required;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class NonTransactionalBeanA {

	@EJB
	private BeanB beanB;

	public void call_save() {
		beanB.save();
	}
}
