package com.java.prep.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * 
 * Output: [ [1,1,6], [1,2,5], [1,7], [2,6] ]
 * 
 * Example 2:
 * 
 * Input: candidates = [2,5,2,1,2], target = 5
 * 
 * Output: [ [1,2,2], [5] ]
 * 
 * 
 * Constraints:
 * 
 * 1 <= candidates.length <= 100
 * 
 * 1 <= candidates[i] <= 50
 * 
 * 1 <= target <= 30
 * 
 */
public class CombinationSumII {

	List<List<Integer>> combination = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		helper(0, target, candidates, new ArrayList<>());
		return combination;
	}

	/**
	 * Complexity - O(n^m) where n is total candidates and m is the target value.
	 * Space - O(n)
	 */
	public void helper(int i, int target, int[] candidates, List<Integer> sum) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			combination.add(new ArrayList<>(sum));
			return;
		}
		if (i == candidates.length) {
			return;
		}
		if (target >= candidates[i]) {
			sum.add(candidates[i]);
			helper(i + 1, target - candidates[i], candidates, sum);
			sum.remove(sum.size() - 1);
		}
		while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
			i++;
		}
		helper(i + 1, target, candidates, sum);
	}

	public static void main(String[] args) {
		CombinationSumII c = new CombinationSumII();
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(c.combinationSum2(candidates, 8));
	}

}
