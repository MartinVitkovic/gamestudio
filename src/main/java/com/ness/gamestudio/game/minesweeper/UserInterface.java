package com.ness.gamestudio.game.minesweeper;

import com.ness.gamestudio.game.minesweeper.core.Field;

public interface UserInterface {

	/**
	 * Starts the game.
	 * @param field field of mines and clues
	 */
	void newGame(Field field);

	/**
	 * Updates user interface - prints the field.
	 */
	void update();

}