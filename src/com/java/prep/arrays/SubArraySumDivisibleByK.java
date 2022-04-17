package com.java.prep.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the number of non-empty
 * subarrays that have a sum divisible by k. A subarray is a contiguous part of
 * an array.
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,0,-2,-3,1], k = 5 Output: 7
 * 
 * Explanation: There are 7 subarrays with a sum divisible by k = 5: [4, 5, 0,
 * -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 
 * Example 2:
 * 
 * Input: nums = [5], k = 9 Output: 0
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 10^4
 * 
 * -10^4 <= nums[i] <= 10^4
 * 
 * 2 <= k <= 10^4
 */
public class SubArraySumDivisibleByK {

	/**
	 * Complexity - O(n). Space - O(n)
	 */
	public int subarraysDivByK(int[] nums, int k) {
		Map<Integer, Integer> sumCount = new HashMap<Integer, Integer>();
		int prefix = 0;
		int result = 0;
		int remainder = 0;
		sumCount.put(remainder, 1);
		for (int i = 0; i < nums.length; i++) {
			prefix += nums[i];
			remainder = prefix % k;
			if (remainder < 0) {
				remainder += k;
			}
			result += sumCount.getOrDefault(remainder, 0);
			sumCount.put(remainder, sumCount.getOrDefault(remainder, 0) + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		SubArraySumDivisibleByK s = new SubArraySumDivisibleByK();
		int nums[] = { 4, 5, 0, -2, -3, 1 };
		System.out.println(s.subarraysDivByK(nums, 5));
	}

}
