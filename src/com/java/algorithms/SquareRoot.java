package com.java.algorithms;

/**
 * @author apoorva
 *
 * compute square root of a number
 */
public class SquareRoot
{
    static double sqrt(double num)
    {
        if(num < 0.0)
            return Double.NaN;

        double eps = 1e-15;
        double temp = num;
        while(Math.abs(temp - num/temp) > eps * temp)
            temp = (num/temp + temp)/2.0;
        return temp;
    }

    public static void  main(String[] main)
    {
        System.out.println("sqrt of 25.6: "+sqrt(25.6));
    }
}
