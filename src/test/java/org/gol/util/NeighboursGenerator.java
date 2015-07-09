package org.gol.util;

import java.util.ArrayList;
import java.util.Collection;

import org.gol.Cell;

public class NeighboursGenerator {

	public Collection<Cell> generateNeighboursWithNumberOfAliveCell(int aliveCells) {
		
		int totalCells = 8;
		
		Collection<Cell> n = new ArrayList<Cell>();

		for (int i = 0; i < totalCells; i++)
		{
			n.add((i < aliveCells) ? Cell.ALIVE() : Cell.DEAD()); 
		}

		return n;
	}

}
