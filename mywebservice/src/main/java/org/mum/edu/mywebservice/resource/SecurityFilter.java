package org.mum.edu.mywebservice.resource;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;
@Provider
public class SecurityFilter implements ContainerRequestFilter {
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIT = "Basic";
	private static final String SECURER_URL_PREFIX = "messages";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURER_URL_PREFIX)) {
			System.out.println(requestContext.getUriInfo().getRequestUri());
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
			if (authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIT, "");
				String decodeString = Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");
				String username = tokenizer.nextToken();
				String pass = tokenizer.nextToken();

				if ("user".equals(username) && "password".equals(pass)) {
					return;
				}
			}
			Response response = Response.status(Response.Status.UNAUTHORIZED).entity("user can't access the resource")
					.build();
			requestContext.abortWith(response);
		}
	}

}
