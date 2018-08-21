package com.java.leetcode;

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
		System.out.println(convertToInteger("-4567"));
	}

}
