package com.ness.gamestudio.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ness.gamestudio.entity.Player;
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
		return entityManager.createQuery("SELECT s FROM Score s WHERE s.game=? ORDER BY s.points ASC")
				.setParameter(1, game).setMaxResults(10).getResultList();
	}

	@Override
	public List<Score> getBestScoresForGame(String game, String player) {
		return entityManager.createQuery("SELECT s FROM Score s WHERE s.game=? AND s.player=? ORDER BY s.points ASC")
				.setParameter(1, game).setParameter(2, player).getResultList();
	}

	@Override
	public void updateScore(Score score) {
		entityManager.createQuery("UPDATE Score SET points=? WHERE ident=?").setParameter(1, score.getPoints())
				.setParameter(2, score.getIdent()).executeUpdate();
	}
}
