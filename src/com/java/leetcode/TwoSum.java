/**
 * 
 */
package com.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target. 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * @author apoorva
 */

public class TwoSum 
{
	public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++)
		{
			int diff = target - nums[i];
			if(map.containsKey(diff) && map.get(diff) != i)
				return new int[]{map.get(diff), i};
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No match");
    }

}
