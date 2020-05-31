package com.home.transactionattribute.notsupported;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class NonTransactionalBeanA_5 {

	@EJB
	private BeanB_5 beanB;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void call_executeNormally() {
		beanB.runOutsideTrx();
	}
}
