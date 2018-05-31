package com.ness.gamestudio.service;

import java.util.List;

import com.ness.gamestudio.entity.Rating;

public interface RatingService {
void addRating(Rating rating);

List<Rating> getRatingForGame(String name, String game);

double getAvgRating(String game);
}
