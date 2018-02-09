package com.lalit;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.sun.research.ws.wadl.Request;

@Path("/users")
public class UserResource {
	@Context
	Request request;
	@Context
	UriInfo uriInfo;
	UserService userService = new UserService();

	public UserResource() {

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Users> getAllUserAsList() {
		return userService.getUserAsList();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Users getUser(@PathParam("id") int id) {
		return userService.getUser(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<Users> createUser( @FormParam("id") int id, @FormParam("name") String name, @FormParam("addr") String addr) {
		Users user = new Users();
		user.setAddr(addr);
		user.setId(id);
		user.setName(name);
		userService.createUser(user);
		return userService.getUserAsList();
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<Users> updateUser( @FormParam("id") int id, @FormParam("name") String name, @FormParam("addr") String addr) {
		Users user = new Users();
		user.setAddr(addr);
		user.setId(id);
		user.setName(name);
		userService.updateUsers(user);
		return userService.getUserAsList();
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/{id}")
	public List<Users> deleteUser( @PathParam("id") int id) {
		userService.deleteUsers(id);
		return userService.getUserAsList();
	}

}
