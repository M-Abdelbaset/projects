package org.koushik.javabrains.messenger.subresource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("main")
public class MainResource {
	
	@Path("/{mainId}/sub/")
	public ISubResource route(@PathParam("mainId") int mainId) {
		ISubResource sb;
		
		if(mainId == 1)
			sb = new SubResource();
		else
			sb = new SubResource2();
		
		return sb;
	}
}
