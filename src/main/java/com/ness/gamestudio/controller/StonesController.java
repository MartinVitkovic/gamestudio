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
import com.ness.gamestudio.game.stones.core.Field;
import com.ness.gamestudio.game.stones.core.Tile;
import com.ness.gamestudio.service.ScoreService;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)

public class StonesController {
	private Field field = new Field(4, 4);

	@Autowired
	private ScoreService scoreService;

	@Autowired
	private PlayerController playerController;

	@RequestMapping("/stones")
	public String stones(@RequestParam(name = "row", required = false) String rowString,
			@RequestParam(name = "column", required = false) String columnString, Model model) {

		try {
			if (!field.isSolved()) {
				int row = Integer.parseInt(rowString);
				int column = Integer.parseInt(columnString);
				field.move(field.getTile(row, column).getValue());
				if (field.isSolved()) {
					Player player = playerController.getLoggedPlayer();
					if (player != null)
						scoreService.addScore(new Score(player.getName(), "stones", field.getScore(), new Date()));
				}
			}
		} catch (NumberFormatException e) {
		}
		setModel(model);
		return "stones";
	}

	public String generateFieldHTML() {
		Formatter f = new Formatter();
		f.format("<table>\n");
		for (int row = 0; row < field.getRowCount(); row++) {
			f.format("<tr>");
			for (int column = 0; column < field.getColumnCount(); column++) {
				f.format("<td>");
				f.format("<a href='/stones?row=%d&column=%d'>", row, column);
				if (field.getTile(row, column) != null) {
					f.format("<img src='/images/stones/%s.png'>", "icons" + field.getTile(row, column).getValue());
				}
				f.format("</a>");
				f.format("</td>");
			}
			f.format("</tr>\n");
		}
		f.format("</table>\n");
		return f.toString();
	}

	private void setModel(Model model) {
		model.addAttribute("scores", scoreService.getBestScoresForGame("stones"));
	}
}
