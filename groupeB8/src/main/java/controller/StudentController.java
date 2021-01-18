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
import entities.Activity;
import entities.Student;
//d�finit le chemin pour ce controller => groupeB8/api/student
@Path("student")
public class StudentController {
	
	@Inject
	StudentDAO studentDAO;
	
	// Retourne une r�ponse (200) contenant la liste de tous les �tudiants
	// header de la requete est GET
	@GET
	public Response query() {
		return Response.ok(studentDAO.query()).build();
	}
	
	// Retourne une r�ponse (200) contenant l'�tudiant si il existe (sinon 404)
	// activity/:id => id est un param�tre 
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") int id) {
		Student s = studentDAO.getById(id);
		if (s == null) {
			return Response.status(404).build();
		}
		return Response.ok(s).build();
	}
	
	// Retourne une r�ponse (200) contenant l'activit� si elle existe
	// student/matricule/:matricule => matricule est un param�tre
	@GET
	@Path("matricule/{matricule}")
	public Response getByMatricule(@PathParam("matricule") String matricule) {
		return Response.ok(studentDAO.getByMatricule(matricule)).build();
	}
	
	// Retourne une r�ponse (200) contenant l'�tudiant cr��
	@POST
	public Response create(Student student) {
		return Response.ok(studentDAO.create(student)).build();
	}
	
	// Retourne une r�ponse (200) contenant la liste d'�tudiant cr��
	@POST
	@Path("all")
	public Response createAll(List<Student> students) {
		return Response.ok(studentDAO.createAll(students)).build();
	}
	
	// Retourne une r�ponse (200) contenant l'�tudiant modifi� 
	@PUT
	public Response update(Student student) {
		if (studentDAO.getById(student.getId()) != null) {
			return Response.ok(studentDAO.update(student)).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	// Retourne une r�ponse (200) quand l'�tudiant est supprim�
	// student/:id => id est un param�tre 
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		if (studentDAO.delete(id)) {
			return Response.ok("Student was deleted").build();
		}
		return Response.status(404).build();
	}
	
	// Retourne une r�ponse (200) quand toute les �tudiants sont supprim�s
	@DELETE
	@Path("all")
	public Response delete() {
		studentDAO.deleteAll();
		return Response.ok("Students were deleted").build();
	}
	
}
