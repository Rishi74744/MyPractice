package com.java.prep.two.pointers;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * Example 1:
 * 
 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 * 
 * Example 2:
 * 
 * Input: nums = [2,0,1] Output: [0,1,2]
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 
 * 1 <= n <= 300
 * 
 * nums[i] is either 0, 1, or 2.
 * 
 * Follow up: Could you come up with a one-pass algorithm using only constant
 * extra space?
 * 
 *
 */
public class SortColors {

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public static void sortColors(int[] nums) {
		int count[] = new int[3];
		int sorted[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			sorted[count[nums[i]] - 1] = nums[i];
			count[nums[i]]--;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sorted[i];
		}
	}

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public static void main(String[] args) {
		int n[] = { 2, 0, 2, 1, 1, 0 };
		sortColors(n);
	}

}
