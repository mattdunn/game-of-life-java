package org.gol.rules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gol.util.NeighboursGenerator.generateNeighboursWithNumberOfAliveCell;

import java.util.Collection;
import java.util.Collections;

import org.gol.Cell;
import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.OverPopulationRule;
import org.gol.rules.ReproductionRule;
import org.junit.Test;

public class ReproductionRuleTest {

	private IRule rule = new ReproductionRule();
	
	@Test
	public void givenDeadCellWithThreeAliveNeighboursShouldBecomeAlive(){
		Collection<Cell> neighbours = generateNeighboursWithNumberOfAliveCell(3);

		Action result = rule.whatNext(Cell.DEAD(), neighbours);

		assertThat(result).isEqualTo(Action.SPAWN);
	}
	
	
	@Test
	public void givenDeadCellWithTwoAliveNeighboursShouldDoNothing(){
		Collection<Cell> neighbours = generateNeighboursWithNumberOfAliveCell(2);

		Action result = rule.whatNext(Cell.DEAD(), neighbours);

		assertThat(result).isEqualTo(Action.NOTHING);
	}
	
	@Test
	public void givenAliveCellShouldDoNothing(){
		Action result = rule.whatNext(Cell.ALIVE(), Collections.emptyList());

		assertThat(result).isEqualTo(Action.NOTHING);
	}
}
