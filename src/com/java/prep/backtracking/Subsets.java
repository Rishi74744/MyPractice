package com.java.prep.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * Example 2:
 * 
 * Input: nums = [0] Output: [[],[0]]
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10
 * 
 * -10 <= nums[i] <= 10
 * 
 * All the numbers of nums are unique.
 *
 */
public class Subsets {

	/**
	 * Constant Space Iterative Solution
	 *
	 * S(n) = (0 × (n C 0) + 1 × (n C 1) + 2 × (n C 2) + … + n × (n C n))
	 * 
	 * Note that (n C k) = (n C n-k).
	 * 
	 * Therefore: S(n) = 0 × (n C n) + 1 × (n C n-1) + 2 × (n C n-2) + … + n × (n C
	 * 0)
	 * 
	 * If we add these two together, we get
	 * 
	 * 2S(n) = n × (n C 0) + n × (n C 1) + … + n × (n C n) = n × (n C 0 + n C 1 + …
	 * + n C n)
	 * 
	 * As per binomial theorem, (n C 0 + n C 1 + … + n C n) = 2^n, so 2*S(n) = n *
	 * 2^n => S(n) = n * 2^(n-1)
	 *
	 * Time Complexity: O(S(N) + n C 0) = O(N * 2^(N-1) + 1) = O(N * 2^N)
	 * 
	 * N = Length of input nums array
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		generateSubsets(0, nums, new ArrayList<>(), result);
		return result;
	}

	/**
	 * Complexity - O(n*2^n), Space - O(1)
	 */
	public List<List<Integer>> subsetsIterative(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null) {
			return result;
		}
		result.add(new ArrayList<>());
		for (int n : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> temp = new ArrayList<>(result.get(i));
				temp.add(n);
				result.add(temp);
			}
		}

		return result;
	}

	/**
	 * Complexity - O(n*2^n), Space - O(n)
	 */
	public static void generateSubsets(int index, int nums[], List<Integer> currentAnswer, List<List<Integer>> result) {
		if (index == nums.length) {
			result.add(new ArrayList<>(currentAnswer));
		} else {
			currentAnswer.add(nums[index]);
			generateSubsets(index + 1, nums, currentAnswer, result);
			currentAnswer.remove(currentAnswer.size() - 1);
			generateSubsets(index + 1, nums, currentAnswer, result);
		}
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		System.out.println(subsets(nums));
	}

}
