package org.mum.edu.mywebservice.resource;

import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.mum.edu.mywebservice.Model.Message;
import org.mum.edu.mywebservice.Service.MessageService;

@Path("/messages")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)

public class MessageResource {
	MessageService ms = new MessageService();

	@GET
	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start,
			@QueryParam("size") int size) {
		if (year > 0) {
			System.out.println("Hello Nebeyou"+year);
			return ms.getAllMessagesForYear(year);
		}
		if (start >=0 && size >= 0) {
			return ms.getAllMessagePaginated(start, size);
		}
		return ms.getAllMessages();

	}
	@GET
	@Path("test")
	public String getParamUsingContext(@BeanParam MessageFilterBean filterBean){
		String path=filterBean.getUriInfo().getAbsolutePath().toString();
		return "Path:"+path+"Cookiess:";
	}
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id) {
		return ms.getMessage(id);
	}

	@POST
	public Response addMessages(Message message,@Context UriInfo urlinfo) {
		Message newMessage=ms.addMessage(message);
		String id=String.valueOf(newMessage.getId());
		URI url=urlinfo.getAbsolutePathBuilder().path(id).build();
		return Response.created(url)
				.entity(message)			
				.build();
		
		//return ms.addMessage(message);
	}

	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID") long id, Message message) {
		
		return ms.updateMessage(message);
	}

	@DELETE
	@Path("/{messageID}")
	public void deteleMessage(@PathParam("messageID") long id) {
		ms.deleteMessage(id);
	}
}
