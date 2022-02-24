package com.java.prep.binary.search;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given an integer array nums, find a peak element, and return its index. If
 * the array contains multiple peaks, return the index to any of the peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 2
 * 
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4] Output: 5
 * 
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, or index number 5 where the peak element is 6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000
 * 
 * -231 <= nums[i] <= 231 - 1
 * 
 * nums[i] != nums[i + 1] for all valid i.
 * 
 */

public class FindPeakElement {

	public int findPeakElement(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		return findPeak(nums, 0, nums.length - 1);
	}

	/**
	 * Complexity - O(logn), Space - O(logn)
	 */
	public int findPeak(int[] nums, int l, int h) {
		if (l > h) {
			return -1;
		}
		int mid = l + (h - l) / 2;
		int peak = -1;
		int leftElement = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
		int rightElement = mid + 1 > nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];
		if (nums[mid] > leftElement && nums[mid] > rightElement) {
			return mid;
		} else {
			peak = findPeak(nums, l, mid - 1);
			if (peak == -1) {
				return findPeak(nums, mid + 1, h);
			}
			return peak;
		}
	}

	public int findPeakCleaner(int[] nums, int l, int h) {
		if (l == h) {
			return l;
		}
		int mid = l + (h - l) / 2;
		if (nums[mid] > nums[mid + 1]) {
			return findPeak(nums, l, mid);
		}
		return findPeak(nums, mid + 1, h);
	}

	/**
	 * Complexity - O(logn), Space - O(1)
	 */
	public int findPeakIterative(int nums[]) {
		int l = 0;
		int h = nums.length - 1;
		while (l < h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] > nums[mid + 1]) {
				h = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		FindPeakElement f = new FindPeakElement();
		int nums[] = { 1, 2, 3, 1 };
//		System.out.println(f.findPeakElement(nums));
		System.out.println(f.findPeakIterative(nums));
	}

}
