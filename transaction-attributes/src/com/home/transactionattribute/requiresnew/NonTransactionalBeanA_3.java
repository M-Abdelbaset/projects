package com.home.transactionattribute.requiresnew;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class NonTransactionalBeanA_3 {

	@EJB
	private BeanB_3 beanB;

	public void call_save() {
		beanB.save();
	}
}
