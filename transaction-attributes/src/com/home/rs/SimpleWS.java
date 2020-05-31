package com.home.rs;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.home.model.Parent;

@Path("/")
public class SimpleWS {

	@EJB
	private Statefulbean statefulbean;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/persist")
	public List<Parent> persistParent(@QueryParam("name") String name,
			@Context HttpServletRequest request) {
		
		Object sfBean = request.getSession().getAttribute("sf");
		if(sfBean == null) {
			request.getSession().setAttribute("sf", statefulbean);
		} 
		
		Statefulbean sf = (Statefulbean) request.getSession().getAttribute("sf");		
		
		return sf.save(name);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Parent updateParent(@QueryParam("id") Integer id,
			@QueryParam("name") String name,
			@Context HttpServletRequest request) {
		Statefulbean sf = (Statefulbean) request.getSession().getAttribute("sf");
		return sf.update(id, name);
	}
	
	@GET
	@Path("/invalidate")
	public void invalidate(@Context HttpServletRequest request) {
		Statefulbean sf = (Statefulbean) request.getSession().getAttribute("sf");
		sf.remove();
		request.getSession().invalidate();	
	}
}
