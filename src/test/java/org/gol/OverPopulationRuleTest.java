package org.gol;

import static org.gol.util.NeighboursGenerator.generateNeighboursWithNumberOfAliveCell;
import static org.junit.Assert.assertEquals;

import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.OverPopulationRule;
import org.junit.Test;


public class OverPopulationRuleTest {

	private IRule rule = new OverPopulationRule();
	
	@Test
	public void givenAliveCellWithFourNeighboursShouldDie()
	{
		assertEquals(rule.whatNext(Cell.ALIVE(), generateNeighboursWithNumberOfAliveCell(4)), Action.DIE);
	}
 }
