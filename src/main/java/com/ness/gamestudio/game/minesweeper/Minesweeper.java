package com.ness.gamestudio.game.minesweeper;

import com.ness.gamestudio.game.minesweeper.consoleui.ConsoleUI;
import com.ness.gamestudio.game.minesweeper.core.Clue;
import com.ness.gamestudio.game.minesweeper.core.Field;
import com.ness.gamestudio.game.minesweeper.core.Tile;

/**
 * Main application class.
 */
public class Minesweeper {
	/** User interface. */
	private UserInterface userInterface;
	private long startMillis = System.currentTimeMillis();
	// private BestTimes bestTimes = new BestTimes();
	private static Minesweeper instance;
	private Settings setting;

	/**
	 * Constructor.
	 */
	private Minesweeper() {
		instance = this;
		userInterface = new ConsoleUI();
		Settings loadSetting = setting.load();
		Field field = new Field(loadSetting.getRowCount(), loadSetting.getColumnCount(), loadSetting.getMineCount());
		userInterface.newGame(field);
	}

	public int getPlayingSeconds() {
		return ((int) (System.currentTimeMillis() - startMillis) / 1000);
	}

	// public BestTimes getBestTimes() {
	// return bestTimes;
	// }

	public static Minesweeper getInstance() {
		if (instance == null) {
			instance = new Minesweeper();
		}
		return instance;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments
	 */
	// public static void main(String[] args) {
	// new Minesweeper();
	// }

	private Settings getSetting() {
		return setting;
	}

	private void setSetting(Settings setting) {
		this.setting = setting;
		setting.save();
	}
}
