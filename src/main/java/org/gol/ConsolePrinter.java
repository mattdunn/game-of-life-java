package org.gol;

public class ConsolePrinter implements GridPrinter {
	
	@Override
	public void print(Cell[][] cells2d) {
		for (Cell[] cells1d : cells2d) {
			for (Cell cell : cells1d) {
				System.out.print(cell);
			}
			System.out.println();
		}
	}

}
