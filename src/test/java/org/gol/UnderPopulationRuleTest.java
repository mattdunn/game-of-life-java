package org.gol;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.gol.rules.IRule;
import org.gol.rules.UnderPopulationRule;
import org.junit.Test;

public class UnderPopulationRuleTest {

	@Test
	public void givenAliveCellWithLessThanTwoNeighboursCellShouldStillBeDead() {
		IRule rule = new UnderPopulationRule();
		assertTrue(rule.shouldIDie(Cell.ALIVE(), this.generateNeighboursWithOneAliveCell()));
	}

	private Collection<Cell> generateNeighboursWithOneAliveCell() {
		Collection<Cell> n = new ArrayList<Cell>();

		n.add(Cell.DEAD());
		n.add(Cell.DEAD());
		n.add(Cell.DEAD());
		n.add(Cell.DEAD());
		n.add(Cell.DEAD());
		n.add(Cell.ALIVE());
		n.add(Cell.DEAD());
		n.add(Cell.DEAD());

		return n;
	}

}
