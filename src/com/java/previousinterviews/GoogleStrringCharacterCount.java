package com.java.previousinterviews;
/*
 * given a string "aaabbbcccc"
 * 
 * print count in encoded format - "4xa3xb4xc"
 * any ASCII charcater could be considered
 * if same character occurs after a few characters, it should be considered as separate.
 * e.g. "aaaabbbbaaaa" should be "4xa4xb4xa"
 */

public class GoogleStrringCharacterCount 
{
	private static String countCharacters(String str)
	{
		int n = str.length();
		int count = 0;
		int prev = 0;
		StringBuilder sb = new StringBuilder("");
		
		char c = str.charAt(0);

		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == c)
			{
				count++;
			}
			else
			{
				prev = count;
				c = str.charAt(i);
				count = 1;
				sb.append(prev).append("x").append(str.charAt(i-1));
			}
			
		}
		sb.append(count).append("x").append(str.charAt(n-1));
		return sb.toString();
	}
		
	public static void main(String[] args) 
	{
		String test = "aaaabbbbccccAAAAA";
		System.out.println(countCharacters(test));
	}

}
