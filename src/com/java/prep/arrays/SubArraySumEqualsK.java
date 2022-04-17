package com.java.prep.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1], k = 2 Output: 2
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3], k = 3 Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2 * 10^4
 * 
 * -1000 <= nums[i] <= 1000
 * 
 * -10^7 <= k <= 10^7
 */
public class SubArraySumEqualsK {

	/**
	 * Complexity - O(n). Space - O(n)
	 */
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> sumCount = new HashMap<Integer, Integer>();
		sumCount.put(0, 1);
		int prefix = 0;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			prefix += nums[i];
			result += sumCount.getOrDefault(prefix - k, 0);
			sumCount.put(prefix, sumCount.getOrDefault(prefix, 0) + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		SubArraySumEqualsK s = new SubArraySumEqualsK();
		int nums[] = { 3, 1, 2, 4, 5, 2, 3 };
		System.out.println(s.subarraySum(nums, 4));
	}

}
