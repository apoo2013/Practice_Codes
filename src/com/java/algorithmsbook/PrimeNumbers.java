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
        if(n < 2)
            return false;
        for(long i = 2; i*i <= n; i++)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(isPrime(3));
    }
}
