package com.ness.gamestudio.game.minesweeper.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class GamePlay {
	@Id
	@GeneratedValue
	private int ident;
	
	private int rowCount;
	
	private int columnCount;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ident_gameplay")
	private Set<MineCoordinate> mineCoordinates;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ident_gameplay")
	@OrderColumn(name = "command_order")
	private List<Command> commands;
	
	public GamePlay() {
	}

	public GamePlay(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
	}

	public int getColumnCount() {
		return columnCount;
	}
	
	public int getRowCount() {
		return rowCount;
	}
	
	public Set<MineCoordinate> getMineCoordinates() {
		return mineCoordinates;
	}
	
	public void setMineCoordinates(Set<MineCoordinate> mineCoordinates) {
		this.mineCoordinates = mineCoordinates;
	}
	
	public void addCommand(Command command) {
		if(commands == null)
			commands = new ArrayList<>();
		commands.add(command);
	}
	
	public List<Command> getCommands() {
		return commands;
	}

	@Override
	public String toString() {
		return "GamePlay [rowCount=" + rowCount + ", columnCount=" + columnCount + ", mineCoordinates="
				+ mineCoordinates + ", commands=" + commands + "]";
	}
}

