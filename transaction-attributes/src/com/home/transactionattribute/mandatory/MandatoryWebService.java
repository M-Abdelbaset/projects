package com.home.transactionattribute.mandatory;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRequiredException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class MandatoryWebService {

	@EJB
	private TransactionalBeanA_4 beanA;
	
	@EJB
	private NonTransactionalBeanA_4 nonbeanA;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/mandatory")
	public void test_requires() {
		try {
			nonbeanA.save();
		}catch (EJBTransactionRequiredException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Done!");
		beanA.call_joinTransaction();
	}
}
