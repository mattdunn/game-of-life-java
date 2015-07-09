package org.gol;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Collections;

import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.UnderPopulationRule;
import org.gol.util.NeighboursGenerator;
import org.junit.Test;

public class UnderPopulationRuleTest {

	private static final NeighboursGenerator neighboursGenerator = new NeighboursGenerator();

	@Test
	public void givenAliveCellWithLessThanTwoNeighboursCellShouldDie() {
		IRule rule = new UnderPopulationRule();
		assertEquals(rule.whatNext(Cell.ALIVE(), this.generateNeighboursWithZeroAliveCells()), Action.DIE);
		assertEquals(rule.whatNext(Cell.ALIVE(), this.generateNeighboursWithOneAliveCell()), Action.DIE);
	}
	
	@Test
	public void givenAliveCellWithTwoOrMoreNeighboursNothingShouldHappenToCell() {
		IRule rule = new UnderPopulationRule();
		assertEquals(rule.whatNext(Cell.ALIVE(), this.generateNeighboursWithTwoAliveCells()), Action.NOTHING);
	}
	
	@Test
	public void givenDeadCellNothingShouldHappenToCell() {
		IRule rule = new UnderPopulationRule();
		assertEquals(rule.whatNext(Cell.DEAD(), Collections.emptyList()), Action.NOTHING);
	}

	private Collection<Cell> generateNeighboursWithZeroAliveCells() {
		return neighboursGenerator.generateNeighboursWithNumberOfAliveCell(0);
	}
	
	private Collection<Cell> generateNeighboursWithOneAliveCell() {
		return neighboursGenerator.generateNeighboursWithNumberOfAliveCell(1);
	}
	
	private Collection<Cell> generateNeighboursWithTwoAliveCells() {
		return neighboursGenerator.generateNeighboursWithNumberOfAliveCell(2);
	}
}
