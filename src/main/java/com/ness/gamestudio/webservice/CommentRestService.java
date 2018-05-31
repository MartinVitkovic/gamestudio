package com.ness.gamestudio.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.ness.gamestudio.entity.Comment;
import com.ness.gamestudio.entity.Score;
import com.ness.gamestudio.service.CommentService;

@Path("/comments")
public class CommentRestService {
	@Autowired
	private CommentService commentService;
	
	@POST
	@Consumes("application/json")
	public Response addComment(Comment comment) {
		commentService.addComment(comment);
		return Response.created(null).build();
	}
	
	@GET
	@Path("/{game}")
	@Produces("application/json")
	public List<Comment> getCommentsForGame(@PathParam("game") String game){
		return commentService.getCommentsForGame(game);
	}
	
	@DELETE
	@Path("/{game}")
	@Produces("application/json")
	public void deleteComment(@PathParam("game") String game, @QueryParam("ident") int id){
		commentService.deleteComment(game, id);
	}	
}
