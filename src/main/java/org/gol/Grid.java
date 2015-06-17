package org.gol;

public class Grid {
	
	Cell[][] cells= new Cell[4][4];
	
	public Grid() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j] = new Cell();
			}
		}
	}

	public int getNumberOfCells() {
		// TODO Auto-generated method stub
		return cells[0].length * cells.length;
	}

	public Cell[][] getCells() {
		return cells;
	}
}
