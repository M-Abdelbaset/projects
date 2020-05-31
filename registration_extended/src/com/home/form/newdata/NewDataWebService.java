package com.home.form.newdata;

import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.home.form.model.Auth;
import com.home.form.model.Contact;
import com.home.form.model.User;

@Path("/form/new")
public class NewDataWebService {
 
	@EJB
	private NewDataBean newDataBean;
	
	@GET
	@Path("/invalidate")
	public void invalidate(@Context HttpServletRequest request) {
		HttpSession userSession = request.getSession();
		userSession.setAttribute("newDataBean", null);
	}
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void getUser(User user, @Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		if(userSession.getAttribute("newDataBean") == null)
			userSession.setAttribute("newDataBean", newDataBean);
		
		((NewDataBean)userSession.getAttribute("newDataBean")).setUserModel(user);
	}
	
	@POST
	@Path("/auth")
	@Consumes(MediaType.APPLICATION_JSON)
	public void getAuth(Auth auth, @Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		((NewDataBean)userSession.getAttribute("newDataBean")).setAuthModel(auth);
	}
	
	@POST
	@Path("/contacts")
	@Consumes(MediaType.APPLICATION_JSON)
	public void getContacts(Set<Contact> contacts, @Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		((NewDataBean)userSession.getAttribute("newDataBean")).setContactModel(contacts);
	}
	
	@GET
	@Path("/save")
	public void save(@Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		((NewDataBean)userSession.getAttribute("newDataBean")).saveAll();
	}
}
