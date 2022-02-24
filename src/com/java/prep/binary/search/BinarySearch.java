package com.java.prep.binary.search;

/**
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4
 * 
 * Explanation: 9 exists in nums and its index is 4
 * 
 * Example 2:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1
 * 
 * Explanation: 2 does not exist in nums so return -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10^4
 * 
 * -10^4 < nums[i], target < 10^4
 * 
 * All the integers in nums are unique. nums is sorted in ascending order.
 *
 */
public class BinarySearch {

	public static int search(int[] nums, int target) {
		return binarySearch(0, nums.length - 1, nums, target);
	}

	public static int binarySearch(int start, int end, int nums[], int target) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (nums[mid] > target) {
			return binarySearch(start, mid - 1, nums, target);
		} else {
			return binarySearch(mid + 1, end, nums, target);
		}
	}

	/**
	 * Complexity - O(logn). Space - O(1)
	 */
	public static void main(String[] args) {
		int nums[] = {};
		int target = 9;
		System.out.println(search(nums, target));
	}

}
