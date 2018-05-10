package com.ness.gamestudio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
	@Id
	@GeneratedValue
	private int ident;
	
	private String player;
	
	private String game;
	
	private int stars;
	
	private Date playedOn;
	
	public Rating() {
	}

	public Rating(String player, String game, int stars, Date playedOn) {
		super();
		this.player = player;
		this.game = game;
		this.stars = stars;
		this.playedOn = playedOn;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Date getPlayedOn() {
		return playedOn;
	}

	public void setPlayedOn(Date playedOn) {
		this.playedOn = playedOn;
	}

	@Override
	public String toString() {
		return "Rating [ident=" + ident + ", player=" + player + ", game=" + game + ", stars=" + stars + ", playedOn="
				+ playedOn + "]";
	}
	
}
