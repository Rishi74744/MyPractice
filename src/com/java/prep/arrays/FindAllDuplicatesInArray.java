package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of length n where all the integers of nums are in
 * the range [1, n] and each integer appears once or twice, return an array of
 * all the integers that appears twice.
 * 
 * You must write an algorithm that runs in O(n) time and uses only constant
 * extra space.
 * 
 * Example 1:
 * 
 * Input: nums = [4,3,2,7,8,2,3,1] Output: [2,3]
 * 
 * Example 2:
 * 
 * Input: nums = [1,1,2] Output: [1]
 * 
 * Example 3:
 * 
 * Input: nums = [1] Output: []
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 
 * 1 <= n <= 10^5
 * 
 * 1 <= nums[i] <= n
 * 
 * Each element in nums appears once or twice.
 */
public class FindAllDuplicatesInArray {

	/**
	 * Complexity - O(n), Space - O(1)
	 */
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]);
			if (nums[val - 1] < 0) {
				result.add(val);
			}
			nums[val - 1] *= -1;
		}
		return result;
	}

	public static void main(String[] args) {
		FindAllDuplicatesInArray f = new FindAllDuplicatesInArray();
		int nums[] = { 4, 3, 2, 7, 8, 2, 3, 3, 1 };
		System.out.println(f.findDuplicates(nums));
	}

}
