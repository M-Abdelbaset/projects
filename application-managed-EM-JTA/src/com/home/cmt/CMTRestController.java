package com.home.cmt;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/cmt")
public class CMTRestController {

	@EJB
	private CMTParentService parentService;
	
	@GET
	@Path("/save")
	public void save() {
		parentService.save();
	}
	
	@GET
	@Path("/trx")
	public void getEntityTransaction() {
		parentService.whenUsingEntityTransaction_methodWillFail();
	}
}
