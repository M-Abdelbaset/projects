package com.home.transactionattribute.never;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class NeverWebService {

	@EJB
	private TransactionalBeanA_2 beanA;
	
	@EJB
	private NonTransactionalBeanA_2 nonbeanA;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/never")
	public void test_never() {
		nonbeanA.runOusideTransaction();
		System.out.println("Done!");
		beanA.call_dontJoinTransaction();
		System.out.println("Done!");
	}
}
