package com.ness.gamestudio.game.concentrate.core;

import java.util.Random;
import java.util.stream.IntStream;

public class Field {
	
	private final Tile[][] tiles;
	
	private final int rowCount;

	private final int columnCount;

	public Field(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		tiles = new Tile[rowCount][columnCount];
		
		generate();
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}
	
	public Tile getTile(int row, int column) {
		return tiles[row][column];
	}
	
	private void generate() {
		generateNumber();
		generateNumber();
	}
	
	private void generateNumber() {
		Random random = new Random();
		int[] data = IntStream.iterate(1, i -> i + 1).limit((rowCount * columnCount)/2).toArray();
		int numberCount = data.length;
		int j = 0;

		while (numberCount > 0) {
			int row = random.nextInt(rowCount);
			int column = random.nextInt(columnCount);

			if (getTile(row, column) == null) {
				tiles[row][column] = new Tile(data[j]);
				numberCount--;
				j++;
			}
		}
	}

}
