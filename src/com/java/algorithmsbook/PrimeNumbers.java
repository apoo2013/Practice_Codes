package com.java.algorithmsbook;

/**
 * @author apoorva
 *
 * To check if a number is prime or not.
 */
public class PrimeNumbers
{
    static boolean isPrime(long n)
    {
        if (n % 2 == 0) 
        	return false;
        for(long i=3; i*i <= n; i+=2) 
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        System.out.println(isPrime(25));
    }
}
