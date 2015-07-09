package org.gol.rules;

import java.util.Collection;

import org.gol.Cell;

public class SafetyPopulationRule implements IRule {

	@Override
	public Action whatNext(Cell cell, Collection<Cell> neighbours) {
		return Action.NOTHING;
	}
}
