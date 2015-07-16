package org.gol;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gol.util.NeighboursGenerator.generateNeighboursWithNumberOfAliveCell;

import java.util.Collection;

import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.SafetyPopulationRule;
import org.junit.Test;

public class SafetyPopulationRuleTest {

	private IRule rule = new SafetyPopulationRule();

	@Test
	public void givenAliveCellWithTwoNeighboursCellShouldStayAlive() {
		Collection<Cell> neighbours = generateNeighboursWithNumberOfAliveCell(2);

		Action result = rule.whatNext(Cell.ALIVE(), neighbours);

		assertThat(result).isEqualTo(Action.NOTHING);
	}

	@Test
	public void givenAliveCellWithThreeNeighboursCellShouldStayAlive() {
		Collection<Cell> neighbours = generateNeighboursWithNumberOfAliveCell(3);

		Action result = rule.whatNext(Cell.ALIVE(), neighbours);

		assertThat(result).isEqualTo(Action.NOTHING);
	}

	@Test
	public void givenDeadCellWithMoreThanThreeAliveNeighboursCellShouldStayDead() {
		Collection<Cell> neighbours = generateNeighboursWithNumberOfAliveCell(4);

		Action result = rule.whatNext(Cell.ALIVE(), neighbours);

		assertThat(result).isEqualTo(Action.NOTHING);
	}

}
