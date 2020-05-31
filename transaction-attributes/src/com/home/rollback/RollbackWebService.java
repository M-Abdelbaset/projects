package com.home.rollback;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RollbackWebService {

	@EJB
	private Rollback rollback;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/rollback")
	public void test_never() {
		rollback.rollback();
		rollback.select();
	}
}
