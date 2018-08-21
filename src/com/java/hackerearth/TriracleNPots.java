package com.java.hackerearth;

/*
Creatnx now wants to decorate his house by flower pots. He plans to buy exactly  ones. He can only buy them
from Triracle's shop. There are only two kind of flower pots available in that shop. The shop is very strange.
If you buy  flower pots of kind 1 then you must pay  and  if you buy  flower pots of kind 2.
Please help Creatnx buys exactly lower pots that minimizes money he pays.

Input Format:
The first line contains a integer denoting the number of test cases.
Each of test case is described in a single line containing three space-separated integers

Output Format
For each test case, print a single line containing the answer.

Sample input : 1
5 1 2
Output: 17
*/

import java.util.Scanner;

public class TriracleNPots
{
    public static int calculateMinCost(int N, int A, int B)
    {
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i <= N; i++)
        {
            double sum = 0;
            sum = (A * Math.pow(i, 2)) + (B * Math.pow(N-i, 2));
            if(sum < minPrice)
                minPrice = (int) sum;
        }
        return minPrice;
    }

    public static void main(String args[] ) throws Exception
    {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();


        for(int k = 0; k < T; k++)
        {
            int N = s.nextInt();
            int A = s.nextInt();
            int B = s.nextInt();

            int out = calculateMinCost(N, A, B);
            System.out.println(out);
        }
        s.close();
    }

}
