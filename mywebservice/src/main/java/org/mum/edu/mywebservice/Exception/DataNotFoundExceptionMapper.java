package org.mum.edu.mywebservice.Exception;

import java.util.Collection;
import java.util.Collections;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.mum.edu.mywebservice.Model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		
		ErrorMessage error=new ErrorMessage(ex.getMessage(), "404", "https://");
		return Response.status(Status.NOT_FOUND)
				.entity(error)
				.build();
		
		
	}

}
