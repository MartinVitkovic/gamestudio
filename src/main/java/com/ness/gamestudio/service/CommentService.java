package com.ness.gamestudio.service;

import java.util.List;

import com.ness.gamestudio.entity.Comment;

public interface CommentService {
	void addComment(Comment comment);

	List<Comment> getCommentsForGame(String game);
}
