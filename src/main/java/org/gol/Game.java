package org.gol;

public class Game {
	Grid grid = null;
    public void run() {
    }

	public void generateInitialState() {
		grid= new Grid();
	}

	public Grid getGrid() {
		return grid;
	}

}
