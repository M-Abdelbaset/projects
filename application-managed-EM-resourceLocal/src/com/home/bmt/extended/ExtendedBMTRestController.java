package com.home.bmt.extended;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/bmt/extended")
public class ExtendedBMTRestController {

	@EJB
	private ExtendedBMTParentService parentService;
	
	@GET
	@Path("/save")
	public void save() {
		parentService.insideTrx();
	}
	
	@GET
	@Path("/join")
	public void multipleTrx() throws Exception {
		parentService.joinTrx();
	}
}
