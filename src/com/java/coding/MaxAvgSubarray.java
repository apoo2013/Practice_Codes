/**
 * 
 */
package com.java.coding;

/**
 * Given an array consisting of n integers, 
 * find the contiguous subarray of given length k that has the maximum average value. 
 * And you need to output the maximum average value. 
 * 
 * @author apoorva
 *
 */
public class MaxAvgSubarray 
{
	public double findMaxAverage(int[] nums, int k) 
    {
        int n = nums.length;
        // Check if 'k' is valid
        if (k > n)
            return -1;
     
        // Compute sum of first 'k' elements
        int sum = nums[0];
        for (int i = 1; i < k; i++)
            sum += nums[i];
     
        int max_sum = sum, max_end = k-1;
     
        // Compute sum of remaining subarrays
        for (int i = k; i < n; i++)
        {
            sum = sum + nums[i] - nums[i-k];
            if (sum > max_sum)
            {
                max_sum = sum;
                max_end = i;
            }
        }
     
        return (double)max_sum/k;
    }

}
