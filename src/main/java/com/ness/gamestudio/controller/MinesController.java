package com.ness.gamestudio.controller;

import java.util.Date;
import java.util.Formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.ness.gamestudio.entity.Player;
import com.ness.gamestudio.entity.Score;
import com.ness.gamestudio.game.minesweeper.core.Clue;
import com.ness.gamestudio.game.minesweeper.core.Field;
import com.ness.gamestudio.game.minesweeper.core.GameState;
import com.ness.gamestudio.game.minesweeper.core.Tile;
import com.ness.gamestudio.service.ScoreService;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class MinesController {
	private Field field = new Field(9, 9, 1);

	private boolean marking;

	@Autowired
	PlayerController playerController;

	@Autowired
	private ScoreService scoreService;

	@RequestMapping("/mines")
	public String mines(@RequestParam(name = "row", required = false) String rowString,
			@RequestParam(name = "column", required = false) String columnString, Model model) {
		try {
			int row = Integer.parseInt(rowString);
			int column = Integer.parseInt(columnString);
			if (field.getState() == GameState.PLAYING) {
				if (marking)
					field.markTile(row, column);
				else {
					field.openTile(row, column);

					if (field.getState() == GameState.SOLVED) {
						Player player = playerController.getLoggedPlayer();
						if (player != null)
							scoreService.addScore(new Score(player.getName(), "mines", field.getScore(), new Date()));
					}
				}
			}
		} catch (NumberFormatException e) {
		}
		setModel(model);
		return "mines";
	}

	@RequestMapping("/mines/new")
	public String minesNew(Model model) {
		field = new Field(9, 9, 1);
		setModel(model);
		return "mines";
	}

	@RequestMapping("/mines/mark")
	public String minesMark(Model model) {
		marking = !marking;
		setModel(model);
		return "mines";
	}

	public String generateFieldHTML() {
		Formatter f = new Formatter();
		f.format("<table>\n");
		for (int row = 0; row < field.getRowCount(); row++) {
			f.format("<tr>");
			for (int column = 0; column < field.getColumnCount(); column++) {
				f.format("<td>");
				f.format("<a href='/mines?row=%d&column=%d'>", row, column);
				f.format("<img src='/images/mines/%s.png'>", getImageName(field.getTile(row, column)));
				f.format("</a>");
				f.format("</td>");
			}
			f.format("</tr>\n");
		}
		f.format("</table>\n");

		return f.toString();
	}

	public boolean isMarking() {
		return marking;
	}

	private Object getImageName(Tile tile) {
		switch (tile.getState()) {
		case CLOSED:
			return "closed";
		case MARKED:
			return "marked";
		case OPEN:
			if (tile instanceof Clue)
				return "open" + ((Clue) tile).getValue();
			else
				return "mine";
		}
		throw new IllegalStateException();
	}

	private void setModel(Model model) {
		model.addAttribute("scores", scoreService.getBestScoresForGame("mines"));
	}

	public String getGameState() {
		return field.getState().toString();
	}
}
