package org.gol;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;

public class GridTest {

	@Test
	public void shouldBeAbleToPrintGridToPrinter() {
		
		Grid grid = new Grid(Cell.State.ALIVE);
		Cell[][] cellsAlive = new Cell[4][4];
		for (int i = 0; i < cellsAlive.length; i++) {
			for (int j = 0; j < cellsAlive.length; j++) {
				cellsAlive[i][j] = new Cell(Cell.State.ALIVE);
			}
		}
		
		GridPrinter printer = mock(GridPrinter.class);
		
		grid.print(printer);
				
		verify(printer).print(AdditionalMatchers.aryEq(cellsAlive));
	}
}
