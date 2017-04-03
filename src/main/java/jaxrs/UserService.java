package jaxrs;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserService {

	@GET
	@Path("{id}")
	public Response getUserById(@PathParam("id") String id) {
		
	   return Response.status(200).entity("getUserById is called, id : " + id).build();

	}
	
	@POST
	@Path("{id}")
	public Response addUserById(@PathParam("id") String id) {
		
	   return Response.status(200).entity("getUserById is called, id : " + id).build();

	}

}