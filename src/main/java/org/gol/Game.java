package org.gol;

public class Game {
	Grid grid = null;

	public void run() {
	}

	public void generateInitialState() {
		this.generateInitialState(Cell.State.ALIVE);
	}

	public void generateInitialState(Cell.State cellState) {
		grid = new Grid(cellState);
	}

	public Grid getGrid() {
		return grid;
	}

}
