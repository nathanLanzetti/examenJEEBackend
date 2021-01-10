package controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import dao.StudentDAO;
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
		return Response.ok(userDAO.getById(id)).build();
	}
	
	@POST
	@Path("auth")
	public Response getById(UserCredentials credentials) {
		return Response.ok(userDAO.logIn(credentials.getLogin(), credentials.getPassword())).build();
	}
	
	@POST
	public Response create(User user) {
		return Response.ok(userDAO.create(user)).build();
	}
}
