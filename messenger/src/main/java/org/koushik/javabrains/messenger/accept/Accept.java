package org.koushik.javabrains.messenger.accept;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.resources.beans.MessageFilterBean;


@Path("accept")
public class Accept {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message getJson(@BeanParam MessageFilterBean filterBean) {
		System.out.println("Json called");
		Message message = new Message(1, "message 1", "me");
		return message;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Message getXml(@BeanParam MessageFilterBean filterBean) {
		System.out.println("xml called");
		Message message = new Message(1, "message 1", "me");
		return message;
	}
}
