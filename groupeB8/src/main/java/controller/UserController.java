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
//définit le chemin pour ce controller => groupeB8/api/user
@Path("user")
public class UserController {
	@Inject
	UserDAO userDAO;
	
	// Retourne une réponse (200) contenant la liste de tous les users
	// header de la requete est GET
	@GET
	public Response query() {
		return Response.ok(userDAO.query()).build();
	}
	
	
	// Retourne une réponse (200) contenant l'activité si elle existe (sinon 404)
	// activity/:id => id est un paramètre 
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") int id) {
		User u = userDAO.getById(id);
		if (u == null) {
			return Response.status(404).build();
		}
		return Response.ok(u).build();
	}
	
	// Retourne une réponse (200) contenant un utilisateur qui existe en DB
	// Route : api/user/auth
	@POST
	@Path("auth")
	public Response logIn(UserCredentials credentials) {
		User u = userDAO.logIn(credentials.getLogin(), credentials.getPassword());
		if (u == null) {
			return Response.status(404).build();
		}
		return Response.ok(u).build();
	}
	
	// Retourne une réponse (200) contenant l'activité a été créé
	@POST
	public Response create(User user) {
		return Response.ok(userDAO.create(user)).build();
	}
}
