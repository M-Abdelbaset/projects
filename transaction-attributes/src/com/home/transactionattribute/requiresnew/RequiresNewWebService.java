package com.home.transactionattribute.requiresnew;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RequiresNewWebService {

	@EJB
	private TransactionalBeanA_3 beanA;
	
	@EJB
	private NonTransactionalBeanA_3 nonbeanA;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/requiresNew")
	public void test_requires() {
		nonbeanA.call_save();
		System.out.println("Done!");
		beanA.call_startNewTransaction();
		System.out.println("Done!");
		beanA.call_rollback();
	}
}
