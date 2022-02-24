package com.java.prep.math;

/**
 * Given an integer array nums of size n, return the minimum number of moves
 * required to make all array elements equal.
 * 
 * In one move, you can increment n - 1 elements of the array by 1.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: 3
 * 
 * Explanation: Only three moves are needed (remember each move increments two
 * elements): [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
 * 
 * Example 2:
 * 
 * Input: nums = [1,1,1] Output: 0
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 
 * 1 <= nums.length <= 10^5
 * 
 * -10^9 <= nums[i] <= 10^9
 * 
 * The answer is guaranteed to fit in a 32-bit integer.
 * 
 */

public class MinimumMovesToEqualArrayElements {

	public int minMoves(int[] nums) {
		int n = nums.length;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			min = Math.min(min, nums[i]);
		}
		return sum - n * min;
	}

	/**
	 * Complexity - O(n) where n is number of elements in input array. Space - O(1).
	 */
	public static void main(String[] args) {
		MinimumMovesToEqualArrayElements m = new MinimumMovesToEqualArrayElements();
		int nums[] = { 5, 2, 2, 3, 4 };
		System.out.println(m.minMoves(nums));
	}

}
