package com.ness.gamestudio.game.stones;

import com.ness.gamestudio.game.stones.consoleui.ConsoleUI;
import com.ness.gamestudio.game.stones.core.Field;

public class MainStones {
	
	private static MainStones instance;
	
//	public static void main(String[] args) {
//		Field field = new Field(4, 3);
//		ConsoleUI ui = new ConsoleUI(field);
//		ui.run();
//	}
	
	public MainStones() {
		Field field = new Field(4, 3);
		ConsoleUI ui = new ConsoleUI(field);
		ui.run();
	}
	
	public static MainStones getInstance() {
		if (instance == null) {
			instance = new MainStones();
		}
		return instance;
	}
}
