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

import dao.StudentDAO;
import dao.UnitDAO;
import entities.Student;
import entities.Unit;

@Path("unit")
public class UnitController {

	@Inject
	UnitDAO unitDAO;
	
	@GET
	public Response query() {
		return Response.ok(unitDAO.query()).build();
	}
	
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") int id) {
		Unit u = unitDAO.getById(id);
		if (u == null) {
			return Response.status(404).build();
		}
		return Response.ok(u).build();
	}
	
	@GET
	@Path("code/{code}")
	public Response getById(@PathParam("code") String code) {
		return Response.ok(unitDAO.getByCode(code)).build();
	}
	
	@POST
	public Response create(Unit unit) {
		return Response.ok(unitDAO.create(unit)).build();
	}
	
	@PUT
	public Response update(Unit unit) {
		if (unitDAO.getById(unit.getId()) != null) {
			return Response.ok(unitDAO.update(unit)).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		if (unitDAO.delete(id)) {
			return Response.ok("Unit was deleted").build();
		}
		return Response.status(404).build();
	}
}
