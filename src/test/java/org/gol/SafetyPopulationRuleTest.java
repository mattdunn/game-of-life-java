package org.gol;

import static org.junit.Assert.assertEquals;

import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.SafetyPopulationRule;
import org.gol.util.NeighboursGenerator;
import org.junit.Test;

public class SafetyPopulationRuleTest {

	private static final NeighboursGenerator neighboursGenerator = new NeighboursGenerator();
	
	@Test
	public void givenAliveCellWithTwoNeighboursCellShouldStayAlive() {
		IRule rule = new SafetyPopulationRule();
		assertEquals(rule.whatNext(Cell.ALIVE(), neighboursGenerator.generateNeighboursWithNumberOfAliveCell(2)), Action.NOTHING);
	}
	
	@Test
	public void givenAliveCellWithThreeNeighboursCellShouldStayAlive() {
		IRule rule = new SafetyPopulationRule();
		assertEquals(rule.whatNext(Cell.ALIVE(), neighboursGenerator.generateNeighboursWithNumberOfAliveCell(3)), Action.NOTHING);
	}

	@Test
	public void givenDeadCellWithMoreThanThreeAliveNeighboursCellShouldStayDead() {
		IRule rule = new SafetyPopulationRule();
		assertEquals(rule.whatNext(Cell.DEAD(), neighboursGenerator.generateNeighboursWithNumberOfAliveCell(4)), Action.NOTHING);
	}

}
