package com.home;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.home.bean.SingletonBean;
import com.home.bean.StatelessBean;

@Path("/bean")
public class WebService {

	@EJB
	private SingletonBean singletonBean;
	
	@EJB
	private StatelessBean statelessBean;
	
	@GET
	@Path("/singleton")
	public void getSingleton(@QueryParam("delay") boolean delay,
			@QueryParam("length") int length) throws Exception {
		System.out.println("Controller received: " + Thread.currentThread().getId());
		singletonBean.access(delay, length);
	}
	
	@GET
	@Path("/stateless")
	public void getStateless(@QueryParam("delay") boolean delay,
			@QueryParam("length") int length,
			@Context HttpServletRequest request) throws Exception {
		System.out.println("Controller received: " + Thread.currentThread().getId() + " for " + statelessBean.date);
		statelessBean.access(delay, length);
	}
}
