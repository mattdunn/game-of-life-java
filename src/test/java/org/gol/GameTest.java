package org.gol;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void runGame() {
        Game game = new Game();
        game.generateInitialState();
        assertNotNull(game.getGrid());
    }
}
