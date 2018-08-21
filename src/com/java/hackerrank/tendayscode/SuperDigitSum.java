package com.java.hackerrank.tendayscode;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author apoorva
 *
 * calculate the sum of all the digits of a number,
 * input parameter is a string
 */
public class SuperDigitSum
{
	static int superDigit(String n, int k) 
	{
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < k; i++)
			sb.append(n);
		
		long num = Long.parseLong(sb.toString());
		
		return superDigit(num);
	}
		
	static int superDigit(long num)
	{
		int sum = 0;
		
		while(num != 0)
		{
			sum += num%10;
			num /= 10;
		}
		if(sum < 10)
			return sum;
		else
			return superDigit(sum);
    }

    public static void main(String[] args) throws IOException 
    {
    	Scanner scanner = new Scanner(System.in);
    	
        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }

}
