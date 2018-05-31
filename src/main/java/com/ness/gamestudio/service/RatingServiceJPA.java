package com.ness.gamestudio.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ness.gamestudio.entity.Rating;

/*
 metoda addRating - pridat rating pre kazdeho hraca len raz
 metoda getRatingForGrame - meno a hraca
 metoda getAvgRating - priemerny rating
 */
@Transactional
public class RatingServiceJPA implements RatingService {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addRating(Rating rating) {
		List<Rating> playerRating = getRatingForGame(rating.getPlayer(), rating.getGame());
		if (playerRating.isEmpty()) {
			entityManager.persist(rating);
		} else {
			playerRating.get(0).setStars(rating.getStars());
		}
	}

	@Override
	public List<Rating> getRatingForGame(String name, String game) {
		return entityManager.createQuery("SELECT r FROM Rating r WHERE r.player=? AND r.game=?").setParameter(1, name)
				.setParameter(2, game).getResultList();
	}

	@Override
	public double getAvgRating(String game) {
		return (double) entityManager.createQuery("SELECT avg(r.stars) FROM Rating r WHERE r.game=?")
				.setParameter(1, game).getSingleResult();
	}

}
