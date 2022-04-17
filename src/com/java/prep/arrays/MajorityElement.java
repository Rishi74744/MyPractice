package com.java.prep.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,3] Output: 3
 * 
 * Example 2:
 * 
 * Input: nums = [2,2,1,1,1,2,2] Output: 2
 * 
 * Constraints:
 * 
 * n == nums.length
 * 
 * 1 <= n <= 5 * 10^4
 * 
 * -10^9 <= nums[i] <= 10^9
 */
public class MajorityElement {

	/**
	 * Complexity - O(nlogn), Space - O(1)
	 */
	public int majorityElementWithConstantSpace(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
		}
		int element = -1;
		int n = (int) Math.floor(nums.length / 2);
		for (int k : m.keySet()) {
			if (m.get(k) > n) {
				element = k;
				break;
			}
		}
		return element;
	}

	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(m.majorityElement(nums));
	}

}
