/**
 * 
 */
package com.java.coding;

import java.util.Scanner;

/**
 * Given an array, , of size distinct elements, sort the array in ascending order using the 
 * Bubble Sort algorithm above. Once sorted, print the following lines:
 * Array is sorted in numSwaps swaps where numSwaps is the number of swaps that took place.
 * First Element: firstElement where firstElement is the first element in the sorted array. 
 * Last Element: lastElement where lastElement is the last element in the sorted array.
 *
 * @author apoorva
 */
public class SortingFirstLast 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[] a = new int[n];
        
        for(int a_i=0; a_i < n; a_i++)
        {
            a[a_i] = in.nextInt();
        }
        
        int temp;
        int swapCount = 0;
        for(int i = 0; i < n; i++)
        {
        	for(int j =0; j < n-1; j++)
        	{
        		if(a[j] > a[j+1])
        		{
        			temp = a[j+1];
        			a[j+1] = a[j];
        			a[j] = temp;
        			swapCount++;
        		}
        	}
        	
        	if(swapCount == 0)
        		break;
        }
        
        System.out.println("Array is sorted in "+swapCount+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);
        
        for(int arr = 0; arr < n; arr++)
        {
        	System.out.println(a[arr]);
        }
        in.close();
	}

}
