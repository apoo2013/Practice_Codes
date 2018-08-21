package com.java.hackerrank.tendayscode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author apoorva
 *
 * We define super digit of an integer using the following rules:

	Given an integer, we need to find the super digit of the integer.

    If x has only digit, then its super digit is x.
    Otherwise, the super digit of x is equal to the super digit of the sum of the digits of x.

	You are given two numbers n and k.
	The number p is created by concatenating the string n (k) times. 
	Continuing the above example where n = 9875, assume your value k = 4. 
	Your initial p = 9875 9875 9875 9875 (spaces added for clarity).
 */

public class SuperDigitBigInteger 
{
	private static final Scanner scanner = new Scanner(System.in);
	
	public static BigInteger sum_n(String n)
	{
		BigInteger sd = BigInteger.valueOf(0);
		for(int i = 0; i < n.length(); i++)
		{
			sd = sd.add(BigInteger.valueOf(Character.getNumericValue(n.charAt(i))));
		}
		return sd;
	}
	
	public static BigInteger super_digit(String n)
	{
		if(n.length() == 1)
			return BigInteger.valueOf(Character.getNumericValue(n.charAt(0)));
		
		return super_digit(sum_n(n).toString());
	}

	public static void main(String[] args) throws IOException 
	{
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        BigInteger b = sum_n(n);
        b = b.multiply(BigInteger.valueOf(k));
        b = super_digit(b.toString());
        bufferedWriter.write(String.valueOf(b));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
	}

}
