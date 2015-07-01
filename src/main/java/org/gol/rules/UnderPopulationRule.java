package org.gol.rules;

import java.util.Collection;
import java.util.stream.Collectors;

import org.gol.Cell;

public class UnderPopulationRule implements IRule{

	@Override
	public Action whatNext(Cell cell, Collection<Cell> neighbours) {
		
		if (cell.isAlive()) {
			Long countOfAliveNeighbours = neighbours.stream().filter((c) -> c.isAlive()).collect(Collectors.counting());	
			if (countOfAliveNeighbours < 2)
			{
				return Action.DIE;
			}
		}
		return Action.NOTHING;
	}

}
