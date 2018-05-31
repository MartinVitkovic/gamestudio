package com.ness.gamestudio.service;

import com.ness.gamestudio.entity.Player;

public interface PlayerService {

	Player login(String name, String password);

	void register(Player player);

}