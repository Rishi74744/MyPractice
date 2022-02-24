package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 
 * 0 <= a, b, c, d < n a, b, c, and d are distinct. nums[a] + nums[b] + nums[c]
 * + nums[d] == target You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,-1,0,-2,2], target = 0 Output:
 * [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * Example 2:
 * 
 * Input: nums = [2,2,2,2,2], target = 8 Output: [[2,2,2,2]]
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200
 * 
 * -10^9 <= nums[i] <= 10^9
 * 
 * -10^9 <= target <= 10^9
 * 
 */

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 4) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			
		}
		return result;
	}

}