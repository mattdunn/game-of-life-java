package org.gol;

import static org.fest.assertions.Assertions.assertThat;
import static org.gol.util.NeighboursGenerator.generateNeighboursWithNumberOfAliveCell;

import java.util.ArrayList;
import java.util.Collection;

import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.OverPopulationRule;
import org.junit.Test;

public class OverPopulationRuleTest {

	private IRule rule = new OverPopulationRule();

	@Test
	public void givenAliveCellWithFourAliveNeighboursShouldDie() {
		Collection<Cell> neighbours = generateNeighboursWithNumberOfAliveCell(4);

		Action result = rule.whatNext(Cell.ALIVE(), neighbours);

		assertThat(result).isEqualTo(Action.DIE);
	}

	@Test
	public void givenAliveCellWithThreeAliveNeighboursShouldDoNothing() {
		Collection<Cell> threeNeighbours = generateNeighboursWithNumberOfAliveCell(3);

		Action result = rule.whatNext(Cell.ALIVE(), threeNeighbours);

		assertThat(result).isEqualTo(Action.NOTHING);
	}
	
	@Test
	public void givenDeadCellShouldDoNothing() {
		Action result = rule.whatNext(Cell.DEAD(), null);

		assertThat(result).isEqualTo(Action.NOTHING);
	}
	
}
