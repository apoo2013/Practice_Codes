package com.java.leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length. 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * @author apoorva
 *
 */
public class RemoveDuplicatesFromArray 
{
	public int removeDuplicates(int[] nums) 
    {
        int n = nums.length;
        
        if(n == 0 || n == 1)
            return n;
        
        int j = 0;
        for(int i = 0; i < n-1; i++)
        {
            if(nums[i] != nums[i+1])
                nums[j++] = nums[i];
        }
        nums[j++] = nums[n-1];
        
        return j;
    }
}
