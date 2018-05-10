package com.ness.gamestudio.service;

import java.util.List;

import com.ness.gamestudio.entity.Score;

public interface ScoreService {
	void addScore(Score score);

	List<Score> getBestScoresForGame(String game);
}
