package com.ness.gamestudio;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ness.gamestudio.consoleui.ConsoleUI;
import com.ness.gamestudio.entity.Comment;
import com.ness.gamestudio.entity.Player;
import com.ness.gamestudio.entity.Rating;
import com.ness.gamestudio.entity.Score;
import com.ness.gamestudio.game.minesweeper.Minesweeper;
import com.ness.gamestudio.game.minesweeper.service.GamePlayService;
import com.ness.gamestudio.game.minesweeper.service.GamePlayServiceJPA;
import com.ness.gamestudio.service.CommentService;
import com.ness.gamestudio.service.CommentServiceJPA;
import com.ness.gamestudio.service.PlayerService;
import com.ness.gamestudio.service.PlayerServiceJPA;
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
		// ConsoleUI ui = new ConsoleUI();
		// ui.run();
	}

	@Bean
	public CommandLineRunner runner(ScoreService scoreService, CommentService commentService,
			RatingService ratingService) {
		return args -> {
			System.out.println("Running");
			//ratingService.addRating(new Rating("peto", "mines", 1, new Date()));
			//ratingService.addRating(new Rating("mato", "mines", 3, new Date()));
			// scoreService.addScore(new Score("mato", "mines", 256, new Date()));
//			 for (Score score : scoreService.getBestScoresForGame("mines"))
//			 System.out.println(score);
//			 for (Comment comment : commentService.getCommentsForGame("mines"))
//			 System.out.println(comment);
//			 for (Rating rating : ratingService.getRatingForGame("peto", "mines"))
//			 System.out.println(rating);
			//System.out.println(ratingService.getAvgRating("mines"));
//			 playerService().register(new Player("mato", "heslo"));
//			 playerService().register(new Player("admin", "admin"));
		};
	}

	@Bean
	public PlayerService playerService() {
		return new PlayerServiceJPA();
	}

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

	@Bean
	public GamePlayService gamePlayService() {
		return new GamePlayServiceJPA();
	}

	// public static Main getInstance() {
	// if (instance == null) {
	// instance = new Main();
	// }
	// return instance;
	// }
}
