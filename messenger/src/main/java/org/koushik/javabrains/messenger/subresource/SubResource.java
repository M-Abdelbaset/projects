package org.koushik.javabrains.messenger.subresource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class SubResource implements ISubResource{

	@GET
	@Override
	public String get(@PathParam("mainId") int id) {
		return "get: " + id;
	}
	
	@GET
	@Path("/{subId}")
	@Override
	public String getWithParam(@PathParam("mainId") int mainId, 
			@PathParam("subId") int subId,
			@QueryParam("count") int count) {
		return "get: " + mainId + " : " + subId + " : " + count;
	}
}
