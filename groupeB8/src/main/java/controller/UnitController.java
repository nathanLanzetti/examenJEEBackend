package controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import dao.StudentDAO;
import dao.UnitDAO;
import entities.Student;
import entities.Unit;
//définit le chemin pour ce controller => groupeB8/api/unit
@Path("unit")
public class UnitController {

	@Inject
	UnitDAO unitDAO;
	
	// Retourne une réponse (200) contenant la liste de toutes les unités
	// header de la requete est GET
	@GET
	public Response query() {
		return Response.ok(unitDAO.query()).build();
	}
	
	// Retourne une réponse (200) contenant un set d'activité sans doublon
	// activity/unique => 
	@GET
	@Path("unique")
	public Response queryWithoutDuplicates() {
		return Response.ok(unitDAO.queryWithoutDuplicates()).build();
	}
	
	// Retourne une réponse (200) contenant l'activité si elle existe (sinon 404)
	// activity/:id => id est un paramètre 
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") int id) {
		Unit u = unitDAO.getById(id);
		if (u == null) {
			return Response.status(404).build();
		}
		return Response.ok(u).build();
	}
	
	// Retourne une réponse (200) contenant l'activité si elle existe
	// unit/code/:code => code est un paramètre
	@GET
	@Path("code/{code}")
	public Response getByCode(@PathParam("code") String code) {
		return Response.ok(unitDAO.getByCode(code)).build();
	}
	
	// Retourne une réponse (200) contenant l'unité crééé
	@POST
	public Response create(Unit unit) {
		return Response.ok(unitDAO.create(unit)).build();
	}
	
	// Retourne une réponse (200) contenant la liste d'unité créé
	@POST
	@Path("all")
	public Response createAll(List<Unit> units) {
		return Response.ok(unitDAO.createAll(units)).build();
	}
	
	// Retourne une réponse (200) contenant l'unité modifié (ou 404)
	@PUT
	public Response update(Unit unit) {
		if (unitDAO.getById(unit.getId()) != null) {
			return Response.ok(unitDAO.update(unit)).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	// Retourne une réponse (200) quand l'unité est supprimé
	// unit/:id => id est un paramètre 
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		if (unitDAO.delete(id)) {
			return Response.ok("Unit was deleted").build();
		}
		return Response.status(404).build();
	}
	
	// Retourne une réponse (200) quand toute les unités sont supprimés
	@DELETE
	@Path("all")
	public Response delete() {
		unitDAO.deleteAll();
		return Response.ok("Units were deleted").build();
	}
}
