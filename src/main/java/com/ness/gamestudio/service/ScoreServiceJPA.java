package com.ness.gamestudio.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ness.gamestudio.entity.Score;

@Transactional
public class ScoreServiceJPA implements ScoreService {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addScore(Score score) {
		entityManager.persist(score);
	}

	@Override
	public List<Score> getBestScoresForGame(String game) {
		return entityManager.createQuery("SELECT s FROM Score s WHERE s.game=? ORDER BY s.points DESC")
				.setParameter(1, game).getResultList();
	}
}
