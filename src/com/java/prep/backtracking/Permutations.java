package com.java.prep.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * Example 2:
 * 
 * Input: nums = [0,1] Output: [[0,1],[1,0]]
 * 
 * Example 3:
 * 
 * Input: nums = [1] Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 6
 * 
 * -10 <= nums[i] <= 10
 * 
 * All the integers of nums are unique.
 */
public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		helper(nums, new ArrayList<>(), result);
		return result;
	}

	public void helper(int nums[], List<Integer> perm, List<List<Integer>> result) {
		if (perm.size() == nums.length) {
			result.add(new ArrayList<>(perm));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!perm.contains(nums[i])) {
					perm.add(nums[i]);
					helper(nums, perm, result);
					perm.remove(perm.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		Permutations per = new Permutations();
		System.out.println(per.permute(nums));
	}

}
