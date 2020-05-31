package com.home.transactionattribute.notsupported;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class NotsupportedWebService {

	@EJB
	private TransactionalBeanA_5 beanA;
	
	@EJB
	private NonTransactionalBeanA_5 nonbeanA;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/notsupported")
	public void test_never() {
		nonbeanA.call_executeNormally();
		System.out.println("Done!");
		beanA.call_suspendTransaction();
		System.out.println("Done!");
	}
}
