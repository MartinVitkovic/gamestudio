package com.ness.gamestudio.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ness.gamestudio.entity.Player;

@Transactional
public class PlayerServiceJPA implements PlayerService {
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.ness.gamestudio.service.PlayerService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Player login(String name, String password) {
		try {
			return (Player) entityManager.createQuery("SELECT p FROM Player p WHERE p.name = ? AND p.password = ?")
					.setParameter(1, name).setParameter(2, password).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.ness.gamestudio.service.PlayerService#register(com.ness.gamestudio.entity.Player)
	 */
	@Override
	public void register(Player player) {
		entityManager.persist(player);
	}

}
