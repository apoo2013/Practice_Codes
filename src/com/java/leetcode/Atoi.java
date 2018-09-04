package com.java.leetcode;

import java.util.Scanner;

/**
 * @author apoorva
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value. 
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function. 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, 
 * no conversion is performed. 
 * If no valid conversion could be performed, a zero value is returned.
 */

public class Atoi
{
	//"-4567"
	public static int convertToInteger(String str)
	{
		str = str.trim();
		
		if(str.length() < 1 || str == "")
			return 0;
		
		int i = 0;
		boolean signed = true;
		
		int len = str.length();
		if(len > 0)
		{
			if(str.charAt(0) == '-')
			{
				signed = true;
				i++;
			}
			else if(str.charAt(0) == '+')
				i++;
		}
		int result = 0;
		while(len > i && str.charAt(i) >= '0' && str.charAt(i) <= '9')
		{
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		
		if(signed == true)
			result = -result;
		
		if(result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		else
			if(result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		System.out.println(Integer.MIN_VALUE);
		return result;
		
	}
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		String in = scanner.next();
		System.out.println(convertToInteger(in));
		
		scanner.close();
	}

}
