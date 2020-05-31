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
	public void save() {
		parentService.whenSavingWithoutTrx_exceptionIsThrown();
	}
	
	@GET
	@Path("/trx")
	public void useEntityTransaction() {
		parentService.whenUsingEntityTransaction_methodWillFail();
	}
	
	@GET
	@Path("/userTrx")
	public void useUserTransaction() throws Exception {
		parentService.whenUsingUserTransaction_thenSave();
	}
	
	@GET
	@Path("/userTrx/multi")
	public void multipleTrx() throws Exception {
		parentService.whenUsingUserTransaction_thenMultipleSave();
	}
	
	@GET
	@Path("/close")
	public void closeEM() throws Exception {
		parentService.whenClosingEM_thenMethodFails();
	}
}
