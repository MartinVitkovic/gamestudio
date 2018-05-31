package com.ness.gamestudio.game.concentrate.core;

public class Tile {

	public enum State {
		OPEN, CLOSE, SOLVED
	}

	private State state = State.CLOSE;
	private final int value;

	public Tile(int value) {
		this.value = value;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getValue() {
		return value;
	}

}
