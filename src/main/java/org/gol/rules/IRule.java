package org.gol.rules;

import java.util.Collection;

import org.gol.Cell;

public interface IRule {
	
	public boolean shouldIDie(Cell cell, Collection<Cell> neighbours);
}
