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
		entityManager.persist(rating);
	}

	@Override
	public List<Rating> getRatingForGame(String game) {
		return entityManager.createQuery("SELECT r FROM Rating r WHERE r.game=? ORDER BY r.stars DESC")
				.setParameter(1, game).getResultList();
	}

}
