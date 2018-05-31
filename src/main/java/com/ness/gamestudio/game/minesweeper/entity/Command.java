package com.ness.gamestudio.game.minesweeper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ness.gamestudio.game.minesweeper.core.Field;

@Entity
public class Command {
	@Id
	@GeneratedValue
	private int ident;
	
	@Enumerated(EnumType.STRING)
	private CommandType commandType;
	
	private int row;
	
	@Column(name = "col")
	private int column;
	
	public Command() {
	}
	
	public Command(CommandType commandType, int row, int column) {
		this.commandType = commandType;
		this.row = row;
		this.column = column;
	}

	public CommandType getCommandType() {
		return commandType;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void execute(Field field) {
		if(commandType.equals(CommandType.OPEN))
			field.openTile(row, column);
		else if(commandType.equals(CommandType.MARK))
			field.markTile(row, column);
	}
	
	@Override
	public String toString() {
		return "Command [commandType=" + commandType + ", row=" + row + ", column=" + column + "]";
	}
}

