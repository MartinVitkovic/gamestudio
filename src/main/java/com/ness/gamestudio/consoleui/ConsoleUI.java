package com.ness.gamestudio.consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.ness.gamestudio.game.minesweeper.Minesweeper;
import com.ness.gamestudio.game.stones.MainStones;

public class ConsoleUI {

	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private Minesweeper minesweeper;
	private MainStones stones;

	/**
	 * Menu options.
	 */
	private enum Option {
		MINESWEEPER, STONES, EXIT
	};

	public void run() {
		// username
		String userName = System.getProperty("user.name");

		// time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
		String date = sdf.format(cal.getTime());

		System.out.println("\n");
		System.out.println("Welcome " + userName + "!");
		System.out.println("Dnes je " + date);
		while (true) {
			switch (showMenu()) {
			case MINESWEEPER:
				minesweeper.getInstance();
				break;
			case STONES:
				stones.getInstance();
				break;
			case EXIT:
				System.exit(0);
				return;
			}
		}
	}

	private Option showMenu() {
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	private String readLine() {
		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

}
