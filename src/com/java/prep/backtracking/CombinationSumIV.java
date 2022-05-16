package com.java.prep.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations that add up to target.
 * 
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3], target = 4
 * 
 * Output: 7
 * 
 * Explanation:
 * 
 * The possible combination ways are:
 * 
 * (1, 1, 1, 1)
 * 
 * (1, 1, 2)
 * 
 * (1, 2, 1)
 * 
 * (1, 3)
 * 
 * (2, 1, 1)
 * 
 * (2, 2)
 * 
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Example 2:
 * 
 * Input: nums = [9], target = 3
 * 
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200
 * 
 * 1 <= nums[i] <= 1000
 * 
 * All the elements of nums are unique.
 * 
 * 1 <= target <= 1000
 * 
 * 
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 */
public class CombinationSumIV {

	/**
	 * Complexity - O(n * k)
	 * 
	 * Space - O(k)
	 */
	public int combinationSum4(int[] nums, int target) {
		int dp[] = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] <= i) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		CombinationSumIV c = new CombinationSumIV();
		int[] nums = { 1, 2, 3 };
		System.out.println(c.combinationSum4(nums, 4));
	}

	int totalCount = 0;

	/**
	 * Complexity - O(n^k)
	 * 
	 * Space - O(n)
	 * 
	 * Result - TLE for few test cases
	 */
	public int combinationSum4Recursive(int[] candidates, int target) {
		helper(target, candidates);
		return totalCount;
	}

	public void helper(int target, int[] candidates) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			totalCount++;
			return;
		}
		for (int i = 0; i < candidates.length; i++) {
			helper(target - candidates[i], candidates);
		}
	}

}
