package org.gol;

import org.junit.Test;
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
        Grid grid= game.getGrid();
        Cell[][] cells = grid.getCells();
        for (Cell[] row: cells){
        	for (Cell col : row){
        		assertNotNull(col);
      
        	}
        }
    }
}
