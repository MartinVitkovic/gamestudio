package com.ness.gamestudio.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ness.gamestudio.entity.Comment;

@Transactional
public class CommentServiceJPA implements CommentService {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addComment(Comment comment) {
		entityManager.persist(comment);
	}

	@Override
	public List<Comment> getCommentsForGame(String game) {
		return entityManager.createQuery("SELECT c FROM Comment c WHERE c.game=?").setParameter(1, game)
				.getResultList();
	}

}
