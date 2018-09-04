/**
 * 
 */
package com.java.hackerrank;

/**
 * Write a function to find the maximum difference between any two elements in an array
 * 
 * @author apoorva
 *
 */
public class MaximumDifference
{
	private int[] elements;
	public int maximumDifference;
	
	public MaximumDifference(int[] anArray)
	{
		elements = anArray;
	}

	public void computeDifference()
	{
		int diff;
		maximumDifference = 0;
		for(int i = 0; i < elements.length; i++)
		{
			for(int j = 0; j <= elements.length-1; j++)
			{
				diff = elements[i] - elements[j];
				System.out.println("arr["+i+"]-arr["+j+"]: "+diff);
				if(Math.abs(diff) > maximumDifference)
				{
					maximumDifference = Math.abs(diff);
				}
			}
		}
		System.out.println("maximumDifference: "+maximumDifference);
	}
}
