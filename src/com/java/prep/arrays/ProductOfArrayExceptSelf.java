package com.java.prep.arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: [24,12,8,6]
 * 
 * Example 2:
 * 
 * Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 10^5
 * 
 * -30 <= nums[i] <= 30
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

	public static int[] productExceptSelf(int nums[]) {
		int prefix[] = new int[nums.length];
		int suffix = 1;
		prefix[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			prefix[i] = nums[i - 1] * prefix[i - 1];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			suffix *= nums[i + 1];
			prefix[i] *= suffix;
		}
		return prefix;
	}

	/**
	 * Complexity - O(n), Space - O(1)
	 */
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4 };
		int res[] = productExceptSelf(nums);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

}
