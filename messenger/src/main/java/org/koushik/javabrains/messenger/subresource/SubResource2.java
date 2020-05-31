package org.koushik.javabrains.messenger.subresource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class SubResource2 implements ISubResource {

	@GET
	@Override
	public String get(@PathParam("mainId") int id) {
		return "get2: " + id;
	}
	
	@GET
	@Path("/{subId}")
	@Override
	public String getWithParam(@PathParam("mainId") int mainId, 
			@PathParam("subId") int subId,
			@QueryParam("count") int count) {
		return "get2: " + mainId + " : " + subId + " : " + count;
	}
}
