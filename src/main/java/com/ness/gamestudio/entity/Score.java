package com.ness.gamestudio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Score {
	@Id
	@GeneratedValue
	private int ident;
	
	private String player;
	
	private String game;
	
	private int points;
	
	private Date playedOn;
	
	public Score() {}

	public Score(String player, String game, int points, Date playedOn) {
		this.player = player;
		this.game = game;
		this.points = points;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Date getPlayedOn() {
		return playedOn;
	}

	public void setPlayedOn(Date playedOn) {
		this.playedOn = playedOn;
	}

	@Override
	public String toString() {
		return "Score [ident=" + ident + ", player=" + player + ", game=" + game + ", points=" + points + ", playedOn="
				+ playedOn + "]";
	};
	
}
