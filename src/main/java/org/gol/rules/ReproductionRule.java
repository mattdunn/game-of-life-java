package org.gol.rules;

import java.util.Collection;
import java.util.stream.Collectors;

import org.gol.Cell;

public class ReproductionRule implements IRule {

	@Override
	public Action whatNext(Cell cell, Collection<Cell> neighbours) {
		if (cell.isAlive()) {
			return Action.NOTHING;
		}
		Long countOfAliveNeighbours = neighbours.stream().filter(Cell::isAlive).collect(Collectors.counting());
		if (countOfAliveNeighbours == 3) {
			return Action.SPAWN;
		}
		return Action.NOTHING;
	}

}
