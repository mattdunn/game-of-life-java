package org.gol;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.gol.rules.Action;
import org.gol.rules.IRule;
import org.gol.rules.UnderPopulationRule;
import org.junit.Test;

public class UnderPopulationRuleTest {

	@Test
	public void givenAliveCellWithLessThanTwoNeighboursCellShouldStillBeDead() {
		IRule rule = new UnderPopulationRule();
		assertEquals(rule.whatNext(Cell.ALIVE(), this.generateNeighboursWithZeroAliveCells()), Action.DIE);
		assertEquals(rule.whatNext(Cell.ALIVE(), this.generateNeighboursWithOneAliveCell()), Action.DIE);
	}
	
	@Test
	public void givenDeadCellWithLessThanTwoNeighboursCellShouldStillBeDead() {
		IRule rule = new UnderPopulationRule();
		assertEquals(rule.whatNext(Cell.DEAD(), this.generateNeighboursWithZeroAliveCells()), Action.NOTHING);
		assertEquals(rule.whatNext(Cell.DEAD(), this.generateNeighboursWithOneAliveCell()), Action.NOTHING);
	}

	private Collection<Cell> generateNeighboursWithZeroAliveCells() {
		return generateNeighboursWithNumberOfAliveCell(0);
	}
	
	private Collection<Cell> generateNeighboursWithOneAliveCell() {
		return generateNeighboursWithNumberOfAliveCell(1);
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
