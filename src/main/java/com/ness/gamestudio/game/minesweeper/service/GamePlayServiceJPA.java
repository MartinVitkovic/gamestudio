package com.ness.gamestudio.game.minesweeper.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ness.gamestudio.game.minesweeper.entity.GamePlay;

@Transactional
public class GamePlayServiceJPA implements GamePlayService {
	@PersistenceContext
	private EntityManager entityManager;

	public void storeGamePlay(GamePlay gamePlay) {
		entityManager.persist(gamePlay);
	}

	@Override
	public GamePlay loadGamePlay(int id) {
		return entityManager.find(GamePlay.class, id);
	}
}

