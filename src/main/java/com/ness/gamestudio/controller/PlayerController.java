package com.ness.gamestudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.ness.gamestudio.entity.Player;
import com.ness.gamestudio.service.PlayerService;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class PlayerController {
	private Player loggedPlayer;

	@Autowired
	PlayerService playerService;

	@RequestMapping("/player")
	public String player() {
		return "player";
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(Player player) {
		loggedPlayer = playerService.login(player.getName(), player.getPassword());
		return "player";
	}

	@RequestMapping("/register")
	public String register(Player player) {
		if (player.getPassword().equals(player.getVerifiedPassword())) {
			playerService.register(player);
			loggedPlayer = player;
		}
		return "player";
	}
	
	@RequestMapping("/logout")
	public String logout(Player player) {
		loggedPlayer = null;
		return "player";
	}

	public Player getLoggedPlayer() {
		return loggedPlayer;
	}
	
	public boolean isLogged() {
		return loggedPlayer != null;
	}

}
