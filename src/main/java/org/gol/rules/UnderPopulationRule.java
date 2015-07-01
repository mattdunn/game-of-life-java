package org.gol.rules;

import java.util.Collection;
import java.util.stream.Collectors;

import org.gol.Cell;

public class UnderPopulationRule implements IRule{

	@Override
	public boolean shouldIDie(Cell cell, Collection<Cell> neighbours) {
		Long countOfAliveNeighbours = neighbours.stream().filter((c) -> c.isAlive()).collect(Collectors.counting());		
		return cell.isAlive() && countOfAliveNeighbours < 2;
	}

}
