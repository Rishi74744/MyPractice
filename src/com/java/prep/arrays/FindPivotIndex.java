package com.java.prep.arrays;

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * 
 * The pivot index is the index where the sum of all the numbers strictly to the
 * left of the index is equal to the sum of all the numbers strictly to the
 * index's right.
 * 
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left. This also applies to the right edge of the
 * array.
 * 
 * Return the leftmost pivot index. If no such index exists, return -1.
 * 
 * Example 1:
 * 
 * Input: nums = [1,7,3,6,5,6] Output: 3
 * 
 * Explanation: The pivot index is 3. Left sum = nums[0] + nums[1] + nums[2] = 1
 * + 7 + 3 = 11 Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3] Output: -1
 * 
 * Explanation: There is no index that satisfies the conditions in the problem
 * statement. Example 3:
 * 
 * Input: nums = [2,1,-1] Output: 0
 * 
 * Explanation: The pivot index is 0. Left sum = 0 (no elements to the left of
 * index 0) Right sum = nums[1] + nums[2] = 1 + -1 = 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10^4
 * 
 * -1000 <= nums[i] <= 1000
 */
public class FindPivotIndex {

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public int pivotIndexWithExtraSpace(int[] nums) {
		int index = -1;
		int prefix[] = new int[nums.length];
		int suffix[] = new int[nums.length];
		int pre = 0;
		int suf = 0;
		for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
			pre += nums[i];
			suf += nums[j];
			prefix[i] = pre;
			suffix[j] = suf;
		}
		for (int i = 0; i < nums.length; i++) {
			if (prefix[i] == suffix[i]) {
				return i;
			}
		}
		return index;
	}

	/**
	 * Complexity - O(n), Space - O(1)
	 */
	public int pivotIndex(int[] nums) {
		int index = -1;
		int suffixSum = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			suffixSum += nums[i];
		}
		int prefixSum = 0;
		for (int i = 0; i < nums.length; i++) {
			suffixSum -= nums[i];
			if (prefixSum == suffixSum) {
				return i;
			}
			prefixSum += nums[i];
		}
		return index;
	}

	public static void main(String[] args) {
		FindPivotIndex f = new FindPivotIndex();
		int nums[] = { 1, 7, 3, 6, 5, 6 };
//		int nums[] = { -1, -1, 0, 1, 1, 0 };
		System.out.println(f.pivotIndex(nums));
	}

}
