package com.ness.gamestudio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private int ident;

	private String player;

	private String game;

	private String comment;

	private Date playedOn;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String player, String game, String comment, Date playedOn) {
		super();
		this.player = player;
		this.game = game;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getPlayedOn() {
		return playedOn;
	}

	public void setPlayedOn(Date playedOn) {
		this.playedOn = playedOn;
	}

	@Override
	public String toString() {
		return "Comment [ident=" + ident + ", player=" + player + ", game=" + game + ", comment=" + comment
				+ ", playedOn=" + playedOn + "]";
	}

}
