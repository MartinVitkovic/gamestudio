package com.ness.gamestudio.game.minesweeper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MineCoordinate {
	@Id
	@GeneratedValue
	private int ident;

	private int row;
	
	@Column(name = "col")
	private int column;

	public MineCoordinate() {
	}
	
	public MineCoordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "MineCoordinate [row=" + row + ", column=" + column + "]";
	}
}

