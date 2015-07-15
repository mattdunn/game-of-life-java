package org.gol.rules;

import java.util.Collection;
import java.util.stream.Collectors;

import org.gol.Cell;

public class OverPopulationRule implements IRule {

	@Override
	public Action whatNext(Cell cell, Collection<Cell> neighbours) {		
		if(cell.isDead()){
			return  Action.NOTHING;
		}
		Long countOfAliveNeighbours = neighbours.stream().filter((c) -> c.isAlive()).collect(Collectors.counting());	
		if (countOfAliveNeighbours > 3){
			return Action.DIE;
		}
		return Action.NOTHING;
	}

}
