package org.gol;

import org.junit.Test;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class GameTest {
	Game game = new Game();

	@Test
	public void givenGenerateShouldBeInitialised() {
		game.generateInitialState();
		assertNotNull(game.getGrid());
	}

	@Test
	public void givenGeneratedGridShouldHave16Cells() {
		game.generateInitialState();
		assertEquals(game.getGrid().getNumberOfCells(), 16);
	}

	@Test
	public void checkCellsNotEmpty() {
		game.generateInitialState();
		Grid grid = game.getGrid();
		Cell[][] cells = grid.getCells();
		for (Cell[] row : cells) {
			for (Cell col : row) {
				assertNotNull(col);

			}
		}
	}

	@Test
	public void shouldInitialiseGridAllDead() {
		game.generateInitialState(Cell.State.DEAD);
		Grid grid = game.getGrid();
		Cell[][] cells = grid.getCells();
		for (Cell[] row : cells) {
			for (Cell col : row) {
				assertTrue(col.isDead());
			}
		}
	}
	
	@Test
	public void shouldInitialiseGridAllAlive() {
		game.generateInitialState(Cell.State.ALIVE);
		Grid grid = game.getGrid();
		Cell[][] cells = grid.getCells();
		for (Cell[] row : cells) {
			for (Cell col : row) {
				assertTrue(col.isAlive());
			}
		}
	}
	
	
	@Test
	public void shouldBeAbleToPrintGridToPrinter() {
		game.generateInitialState(Cell.State.ALIVE);
		GridPrinter printer = mock(GridPrinter.class);
		game.getGrid().print(printer);
		verify(printer).print();
	}
}
