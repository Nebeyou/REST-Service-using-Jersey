package org.mum.edu.mywebservice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/secured")
public class SecuredResource {
	@GET
	@Path("message")
	@Produces(MediaType.TEXT_PLAIN )
	public String securedMethod(){
		return "this API is secured ";
	}

}