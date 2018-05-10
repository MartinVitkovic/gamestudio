package com.ness.gamestudio;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ness.gamestudio.consoleui.ConsoleUI;
import com.ness.gamestudio.entity.Comment;
import com.ness.gamestudio.entity.Rating;
import com.ness.gamestudio.entity.Score;
import com.ness.gamestudio.game.minesweeper.Minesweeper;
import com.ness.gamestudio.service.CommentService;
import com.ness.gamestudio.service.CommentServiceJPA;
import com.ness.gamestudio.service.RatingService;
import com.ness.gamestudio.service.RatingServiceJPA;
import com.ness.gamestudio.service.ScoreService;
import com.ness.gamestudio.service.ScoreServiceJPA;

@Configuration
@SpringBootApplication
public class Main {
	
	private static Main instance;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		ConsoleUI ui = new ConsoleUI();
		ui.run();
	}

	@Bean
	public CommandLineRunner runner(ScoreService scoreService, CommentService commentService,
			RatingService ratingService) {
		return args -> {
			System.out.println("Running");
			// scoreService().addScore(new Score("jaro", "mines", 250, new Date()));
			for (Score score : scoreService.getBestScoresForGame("mines"))
				System.out.println(score);
			for (Comment comment : commentService.getCommentsForGame("mines"))
				System.out.println(comment);
			for (Rating rating : ratingService.getRatingForGame("mines"))
				System.out.println(rating);
		};
	}

	// @Bean
	// public CommandLineRunner runner(CommentService commentService) {
	// return args -> {
	// System.out.println("Running");
	//// commentService().addComment(new Comment("jaro", "mines", "pekna hra", new
	// Date()));
	// for(Comment comment : commentService.getCommentsForGame("mines"))
	// System.out.println(comment);
	// };
	// }

	// @Bean
	// public CommandLineRunner runner(RatingService ratingService) {
	// return args -> {
	// System.out.println("Running");
	//// ratingService().addRating(new Rating("jaro", "mines", 5, new Date()));
	// for(Rating rating : ratingService.getRatingForGame("mines"))
	// System.out.println(rating);
	// };
	// }

	@Bean
	public RatingService ratingService() {
		return new RatingServiceJPA();
	}

	@Bean
	public CommentService commentService() {
		return new CommentServiceJPA();
	}

	@Bean
	public ScoreService scoreService() {
		return new ScoreServiceJPA();
	}
	
	public static Main getInstance() {
		if (instance == null) {
			instance = new Main();
		}
		return instance;
	}
}
