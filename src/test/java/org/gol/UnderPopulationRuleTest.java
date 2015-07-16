package org.gol;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gol.util.NeighboursGenerator.generateNeighboursWithNumberOfAliveCell;

import java.util.Collection;
import java.util.Collections;

import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.UnderPopulationRule;
import org.junit.Test;

public class UnderPopulationRuleTest {
	private IRule rule = new UnderPopulationRule();

	@Test
	public void givenAliveCellWithNoAliveNeighboursCellShouldDie() {
		Collection<Cell> neighbours = generateNeighboursWithNumberOfAliveCell(0);

		Action result = rule.whatNext(Cell.ALIVE(), neighbours);

		assertThat(result).isEqualTo(Action.DIE);
	}
	
	@Test
	public void givenAliveCellWithOneAliveNeighbourCellShouldDie() {
		Collection<Cell> neighbours = generateNeighboursWithNumberOfAliveCell(1);

		Action result = rule.whatNext(Cell.ALIVE(), neighbours);

		assertThat(result).isEqualTo(Action.DIE);
	}

	@Test
	public void givenAliveCellWithTwoAliveNeighboursNothingShouldHappenToCell() {
		Collection<Cell> neighbours = generateNeighboursWithNumberOfAliveCell(2);

		Action result = rule.whatNext(Cell.ALIVE(), neighbours);

		assertThat(result).isEqualTo(Action.NOTHING);
	}

	@Test
	public void givenDeadCellNothingShouldHappenToCell() {
		Action result = rule.whatNext(Cell.DEAD(), Collections.emptyList());

		assertThat(result).isEqualTo(Action.NOTHING);
	}
}
