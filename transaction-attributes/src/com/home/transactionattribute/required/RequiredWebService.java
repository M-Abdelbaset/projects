package com.home.transactionattribute.required;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RequiredWebService {

	@EJB
	private TransactionalBeanA beanA;
	
	@EJB
	private NonTransactionalBeanA nonbeanA;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/required")
	public void test_requires() {
		nonbeanA.call_save();
		System.out.println("Done!");
		beanA.call_joinTransaction();
		System.out.println("Done!");
		beanA.call_rollback();
	}
}
