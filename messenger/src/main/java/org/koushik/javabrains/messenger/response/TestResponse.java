package org.koushik.javabrains.messenger.response;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("body")
public class TestResponse {

	@GET
	public Response get() {
		return Response
				.ok()
				.entity("Done")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	public Response post(@Context UriInfo uri) {
		return Response
				.created(uri.getAbsolutePathBuilder().path("123").build())
				.entity("Done")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
