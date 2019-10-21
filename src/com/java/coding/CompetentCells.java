package com.java.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* Eight houses, represented as cells are arranged in a straight line. Each day, every cell competes with its adjacent cells (neighbors)
 * Integer value of 1 represents active cell and integer value of 0 represents inactive cell.
 * If neighbors on both sides of a cell are either active or inactive, the cell becomes inactive the next day, otherwise it becomes active.
 * Two cells on each end have a single adjacent cell, so assume the unoccupied space on the opposite side is an inactive cell.
 * Even after updating the cell state, consider its previous state when updating the state of other cells. The state of all cells must be updated simultaneously.
 * 
 * Write an algorithm to output the state of the cells after given number of days.
 * 
 * Input: Function consists of two arguments - states ->  list of integers representing current state of cells 
 * 											   days -> number of days
 * 
 * Output: list of integers representing the cell state after given number of days	
 * 
 * (Note: List of integers contain 0's and 1's only)
 */

public class CompetentCells 
{
	private List<Integer> result = new ArrayList<Integer>();
	
	public List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> currentStates = Arrays.stream(states).boxed().collect(Collectors.toList());
        return getStatesAfterDDays(currentStates, days);

    }
	
	private List<Integer> getStatesAfterDDays(List<Integer> currentStates, int days)
	{
		List<Integer> changedStates = new ArrayList<Integer>();
		int ends = 0;
		if(days != 0)
		{
			for(int i = 0; i < currentStates.size(); i++)
			{
				if(i == 0)
				{
					changedStates.add(calculateState(ends, currentStates.get(i+1)));
				}
				else if(i == 7)
				{
					changedStates.add(calculateState(currentStates.get(i-1), ends));
				}
				else
					changedStates.add(calculateState(currentStates.get(i-1), currentStates.get(i+1)));
			}
			
			if(days == 1)
			{
				result = new ArrayList<Integer>(changedStates);
				return result;
			}
			days = days - 1;
			getStatesAfterDDays(changedStates, days);
		}
		return result;
	}
	
	private int calculateState(int left, int right)
	{
		if((left == 0 && right == 0) || (left == 1 && right == 1))
			return 0;
		return 1;
	}
}
