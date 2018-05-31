package com.ness.gamestudio.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.ness.gamestudio.entity.Rating;
import com.ness.gamestudio.service.RatingService;

@Path("/ratings")
public class RatingRestService {
	@Autowired
	private RatingService ratingService;
	
	@POST
	@Consumes("application/json")
	public Response addRating(Rating rating) {
		ratingService.addRating(rating);
		return Response.created(null).build();
	}
	
	@GET
	@Path("/{game}")
	@Produces("application/json")
	public double getAvgRating(@PathParam("game") String game) {
		return ratingService.getAvgRating(game);
	}
}
