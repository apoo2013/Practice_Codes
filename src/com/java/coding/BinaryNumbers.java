/**
 * 
 */
package com.java.coding;

import java.util.Scanner;
import java.util.Stack;

/**
 * Given a base-10 integer, n, convert it to binary (base-2). 
 * Then find and print the base-10 integer denoting the maximum number of 
 * consecutive 1's in n's binary representation.
 * 
 * @author apoorva
 *
 */
public class BinaryNumbers 
{
	public static void main(String[] args) 
	{
		System.out.println("enter number: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int remainder, count = 0, min = 0, len = 0;
		
		while (n>0)
		{
			remainder = n%2;
			System.out.print(remainder);
			if(remainder == 1)
			{
				count += 1;
				if(count >= min)
					min = count;
			}
			else
			{
				count = 0;
			}
			len++;
			n = n/2;
			stack.push(Integer.valueOf(n));
		}

		System.out.println("Count: "+min);	
		
		in.close();
	}

}
