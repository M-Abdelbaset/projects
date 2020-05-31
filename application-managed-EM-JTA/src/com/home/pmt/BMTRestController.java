package com.home.pmt;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/pmt")
public class BMTRestController {

	@EJB
	private BMTParentService parentService;
	
	@GET
	@Path("/save")
	public void save() throws Exception {
		parentService.whenCreatingEMWithinActiveUserTrx_thenSave();
	}
	
	@GET
	@Path("/save2")
	public void save2() throws Exception {
		parentService.whenCreatingEMNoActiveUserTrx_thenNothing();
	}
	
	@GET
	@Path("/save3")
	public void save3() throws Exception {
		parentService.whenCreatingEMOutsideActiveUserTrx_thenNothing();
	}
	
	@GET
	@Path("/save4")
	public void save4() throws Exception {
		parentService.whenCreatingEMOutsideActiveUserTrx_thenJoin();
	}
	
	@GET
	@Path("/trx")
	public void useEntityTransaction() throws Exception {
		parentService.whenUsingEntityTransaction_methodWillFail();
	}
	
	@GET
	@Path("/userTrx/multi")
	public void multipleTrx() throws Exception {
		parentService.appManagedEMScopeIsTillClosed();
	}
	
	@GET
	@Path("/userTrx/multi2")
	public void multipleTrx2() throws Exception {
		parentService.appManagedEMScopes();
	}
}
