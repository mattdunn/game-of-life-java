package org.gol.rules;

import java.util.Collection;

import org.gol.Cell;

public interface IRule {
	
	public Action whatNext(Cell cell, Collection<Cell> neighbours);
}
