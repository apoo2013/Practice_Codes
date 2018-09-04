/**
 * 
 */
package com.java.hackerrank;

import java.util.Scanner;

/**
 * Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface.
 * The implementation for the divisorSum(n) method must return the sum of all divisors of n.
 * @author apoorva
 *
 */
interface AdvancedArithmetic
{
	int divisorSum(int n);
}

class Calc implements AdvancedArithmetic
{
	public int divisorSum(int n)
	{
		int sum = 0;
		int i = 1;
		while(i <= n)
		{
			if(n%i == 0)
				sum += i;
			i++;
		}
		return sum;
	}
}
public class InterfaceSolution 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		AdvancedArithmetic myCalc = new Calc();
		int sum = myCalc.divisorSum(n);
		System.out.println("I implemented: "+myCalc.getClass().getInterfaces()[0].getName());
		System.out.println(sum);
	}
}
