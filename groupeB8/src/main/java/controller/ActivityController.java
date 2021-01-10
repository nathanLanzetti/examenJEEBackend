package controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import dao.ActivityDAO;
import entities.Activity;

@Path("activity")
public class ActivityController {
	@Inject
	ActivityDAO activityDAO;
	
	/*
	@GET
	public Response query() {
		return Response.ok(activityDAO.query()).build();
	}
	*/
	
	@POST
	public Response create(Activity activity) {
		return Response.ok(activityDAO.create(activity)).build();
	}
}
