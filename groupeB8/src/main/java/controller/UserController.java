package controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import dao.UserDAO;
import entities.User;
import models.UserCredentials;

@Path("user")
public class UserController {
	@Inject
	UserDAO userDAO;
	
	@GET
	public Response query() {
		return Response.ok(userDAO.query()).build();
	}
	
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") int id) {
		User u = userDAO.getById(id);
		if (u == null) {
			return Response.status(404).build();
		}
		return Response.ok(u).build();
	}
	
	@POST
	@Path("auth")
	public Response logIn(UserCredentials credentials) {
		User u = userDAO.logIn(credentials.getLogin(), credentials.getPassword());
		if (u == null) {
			return Response.status(404).build();
		}
		return Response.ok(u).build();
	}
	
	@POST
	public Response create(User user) {
		return Response.ok(userDAO.create(user)).build();
	}
}
