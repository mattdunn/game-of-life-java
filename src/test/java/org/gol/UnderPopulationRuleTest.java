package org.gol;

import static org.gol.util.NeighboursGenerator.generateNeighboursWithNumberOfAliveCell;
import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.UnderPopulationRule;
import org.junit.Test;

public class UnderPopulationRuleTest {

	@Test
	public void givenAliveCellWithLessThanTwoNeighboursCellShouldDie() {
		IRule rule = new UnderPopulationRule();
		assertEquals(rule.whatNext(Cell.ALIVE(), generateNeighboursWithNumberOfAliveCell(0)), Action.DIE);
		assertEquals(rule.whatNext(Cell.ALIVE(), generateNeighboursWithNumberOfAliveCell(1)), Action.DIE);
	}
	
	@Test
	public void givenAliveCellWithTwoOrMoreNeighboursNothingShouldHappenToCell() {
		IRule rule = new UnderPopulationRule();
		assertEquals(rule.whatNext(Cell.ALIVE(), generateNeighboursWithNumberOfAliveCell(2)), Action.NOTHING);
	}
	
	@Test
	public void givenDeadCellNothingShouldHappenToCell() {
		IRule rule = new UnderPopulationRule();
		assertEquals(rule.whatNext(Cell.DEAD(), Collections.emptyList()), Action.NOTHING);
	}
}
