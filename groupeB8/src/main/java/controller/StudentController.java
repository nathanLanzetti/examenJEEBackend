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
import entities.Student;

@Path("student")
public class StudentController {
	
	@Inject
	StudentDAO studentDAO;
	
	@GET
	public Response query() {
		return Response.ok(studentDAO.query()).build();
	}
	
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") int id) {
		return Response.ok(studentDAO.getById(id)).build();
	}
	
	@GET
	@Path("matricule/{matricule}")
	public Response getById(@PathParam("matricule") String matricule) {
		return Response.ok(studentDAO.getByMatricule(matricule)).build();
	}
	
	@POST
	public Response create(Student student) {
		return Response.ok(studentDAO.create(student)).build();
	}
	
	@PUT
	public Response update(Student student) {
		if (studentDAO.getById(student.getId()) != null) {
			return Response.ok(studentDAO.update(student)).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		if (studentDAO.delete(id)) {
			return Response.ok("Student was deleted").build();
		}
		return Response.status(404).build();
	}
	
}
