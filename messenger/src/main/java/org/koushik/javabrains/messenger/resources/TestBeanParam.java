package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.koushik.javabrains.messenger.resources.beans.MessageFilterBean;

@Path("bean")
public class TestBeanParam {
	
	@GET
	public String test(@BeanParam MessageFilterBean filterBean) {
		if(filterBean.getYear() < 1)
			throw new BadRequestException("Wrong year");
		return filterBean.toString();
	}
	
	@GET
	@Path("/context/{id}") 
	public String testContext(@Context HttpHeaders hp, @Context UriInfo uri) {
		System.out.println(uri.getAbsolutePath());
		System.out.println(uri.getBaseUri());
		return hp.getRequestHeaders().toString() + " " + uri.getAbsolutePath();
	}
}
