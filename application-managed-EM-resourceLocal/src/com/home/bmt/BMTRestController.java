package com.home.bmt;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/bmt")
public class BMTRestController {

	@EJB
	private BMTParentService parentService;
	
	@GET
	@Path("/save")
	public void save() {
		parentService.save();
	}
	
	@GET
	@Path("/multi")
	public void multipleTrx() throws Exception {
		parentService.PCOpenTillEMClosed();
	}
	
	@GET
	@Path("/multi2")
	public void multipleTrx2() throws Exception {
		parentService.PCOpenTillEMClosed2();
	}
}
