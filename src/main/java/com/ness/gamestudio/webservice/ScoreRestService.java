package com.ness.gamestudio.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.ness.gamestudio.entity.Score;
import com.ness.gamestudio.service.ScoreService;

@Path("/scores")
public class ScoreRestService {
	@Autowired
	private ScoreService scoreService;
	
	@POST
	@Consumes("application/json")
	public Response addScore(Score score) {
		scoreService.addScore(score);
		return Response.created(null).build();
	}
	
	@GET
	@Path("/{game}")
	@Produces("application/json")
	public List<Score> getBestScoresForGame(@PathParam("game") String game, @QueryParam("player") String player){
		if(player == null) {
			return scoreService.getBestScoresForGame(game);
		} else {
			return scoreService.getBestScoresForGame(game, player);
		}
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateScoreForGame(Score score) {
		scoreService.updateScore(score);
		return Response.noContent().build();
	}

}
