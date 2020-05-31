package com.home.form.editdata;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.home.form.model.Auth;
import com.home.form.model.Contact;
import com.home.form.model.User;

@Path("/form/edit")
public class EditDataWebService {
 
	@EJB
	private EditDataBean editDataBean;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "hello world";
	}
	
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") Integer userId, 
			@Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		if(userSession.getAttribute("editDataBean") == null)
			userSession.setAttribute("editDataBean", editDataBean);
		
		return ((EditDataBean)userSession.getAttribute("editDataBean")).getUserModel(userId);
	}
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User user, @Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		((EditDataBean)userSession.getAttribute("editDataBean")).updateUserModel(user);
	}
	
	@GET
	@Path("/auth/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Auth getAuth(@PathParam("id") Integer userId, 
			@Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		return ((EditDataBean)userSession.getAttribute("editDataBean")).getAuthModel(userId);
	}
	
	@POST
	@Path("/auth")
	@Consumes(MediaType.APPLICATION_JSON)
	public void getAuth(Auth auth, @Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		((EditDataBean)userSession.getAttribute("editDataBean")).updateAuthModel(auth);
	}

	@POST
	@Path("/contact")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addContact(Contact contact, @Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		((EditDataBean)userSession.getAttribute("editDataBean")).saveContactModel(contact);
	}
	
	@GET
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(@Context HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		((EditDataBean)userSession.getAttribute("editDataBean")).saveAll();
	}
}
