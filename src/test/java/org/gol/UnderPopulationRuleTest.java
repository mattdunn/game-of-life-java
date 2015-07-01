package org.gol;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.UnderPopulationRule;
import org.junit.Test;

public class UnderPopulationRuleTest {

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
		return generateNeighboursWithNumberOfAliveCell(0);
	}
	
	private Collection<Cell> generateNeighboursWithOneAliveCell() {
		return generateNeighboursWithNumberOfAliveCell(1);
	}
	
	private Collection<Cell> generateNeighboursWithTwoAliveCells() {
		return generateNeighboursWithNumberOfAliveCell(2);
	}
	
	private Collection<Cell> generateNeighboursWithNumberOfAliveCell(int aliveCells) {
		
		int totalCells = 8;
		
		Collection<Cell> n = new ArrayList<Cell>();

		for (int i = 0; i < totalCells; i++)
		{
			n.add((i < aliveCells) ? Cell.ALIVE() : Cell.DEAD()); 
		}

		return n;
	}

}
