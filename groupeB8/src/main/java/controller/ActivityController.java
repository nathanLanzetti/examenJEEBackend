package controller;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import dao.ActivityDAO;
import entities.Activity;
import entities.User;
// définit le chemin pour ce controller => groupeB8/api/activity
@Path("activity")
public class ActivityController {
	
	@Inject
	ActivityDAO activityDAO;
	
	// Retourne une réponse (200) contenant la liste de toutes les activités
	// header de la requete est GET
	@GET
	public Response query() {
		return Response.ok(activityDAO.query()).build();
	}
	
	// Retourne une réponse (200) contenant l'activité si elle existe (sinon 404)
	// activity/:id => id est un paramètre 
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") int id) {
		Activity a = activityDAO.getById(id);
		if (a == null) {
			return Response.status(404).build();
		}
		return Response.ok(a).build();
	}
	
	// Retourne une réponse (200) contenant l'activité si elle existe
	// activity/title/:title => title est un paramètre
	@GET
	@Path("title/{title}")
	public Response getByTitle(@PathParam("title") String title) {
		return Response.ok(activityDAO.getByTitle(title)).build();
	}
	
	// Retourne une réponse (200) contenant l'activité a été créé
	@POST
	public Response create(Activity activity) {
		return Response.ok(activityDAO.create(activity)).build();
	}
	
	// Retourne une réponse (200) contenant l'activité modifié 
	@PUT
	public Response update(Activity activity) {
		if (activityDAO.getById(activity.getId()) != null) {
			return Response.ok(activityDAO.update(activity)).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	// Retourne une réponse (200) quand l'activité est supprimé
	// activity/:id => id est un paramètre 
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		if (activityDAO.delete(id)) {
			return Response.ok("Activity was deleted").build();
		}
		return Response.status(404).build();
	}
}
