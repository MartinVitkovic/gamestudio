package com.ness.gamestudio.game.minesweeper.service;

import com.ness.gamestudio.game.minesweeper.entity.GamePlay;

public interface GamePlayService {
	public void storeGamePlay(GamePlay gamePlay);
	
	public GamePlay loadGamePlay(int id);
}