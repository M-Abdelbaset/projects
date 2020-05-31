package org.koushik.javabrains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		ErrorMessage em = new ErrorMessage();
		em.setMessage(exception.getMessage());
		return Response.serverError().entity(em).build();
	}
}
