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

@Path("activity")
public class ActivityController {
	
	@Inject
	ActivityDAO activityDAO;
	
	@GET
	public Response query() {
		return Response.ok(activityDAO.query()).build();
	}
	
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") int id) {
		return Response.ok(activityDAO.getById(id)).build();
	}
	
	@GET
	@Path("title/{title}")
	public Response getById(@PathParam("title") String title) {
		return Response.ok(activityDAO.getByTitle(title)).build();
	}
	
	@POST
	public Response create(Activity activity) {
		return Response.ok(activityDAO.create(activity)).build();
	}
	
	@PUT
	public Response update(Activity activity) {
		if (activityDAO.getById(activity.getId()) != null) {
			return Response.ok(activityDAO.update(activity)).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		if (activityDAO.delete(id)) {
			return Response.ok("Activity was deleted").build();
		}
		return Response.status(404).build();
	}
}
