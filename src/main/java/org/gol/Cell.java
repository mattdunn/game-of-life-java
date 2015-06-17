package org.gol;

import org.gol.Cell.State;

public class Cell {
	
	private State cellState;

	enum State {ALIVE, DEAD};
	
	public Cell(State cellState) {
		this.cellState = cellState;
	}

	public boolean isDead() {
		return cellState == State.DEAD;
	}

	public boolean isAlive() {
		return cellState == State.ALIVE;
	}

}
