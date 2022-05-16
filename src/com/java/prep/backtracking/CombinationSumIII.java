package com.java.prep.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * Only numbers 1 through 9 are used.
 * 
 * Each number is used at most once.
 * 
 * Return a list of all possible valid combinations. The list must not contain
 * the same combination twice, and the combinations may be returned in any
 * order.
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output: [[1,2,4]]
 * 
 * Explanation:
 * 
 * 1 + 2 + 4 = 7
 * 
 * There are no other valid combinations.
 * 
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * 
 * Explanation:
 * 
 * 1 + 2 + 6 = 9
 * 
 * 1 + 3 + 5 = 9
 * 
 * 2 + 3 + 4 = 9
 * 
 * There are no other valid combinations.
 * 
 * Example 3:
 * 
 * Input: k = 4, n = 1
 * 
 * Output: []
 * 
 * Explanation: There are no valid combinations.
 * 
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is
 * 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 * 
 * 
 * Constraints:
 * 
 * 2 <= k <= 9
 * 
 * 1 <= n <= 60
 */
public class CombinationSumIII {

	Set<String> takenCombination = new HashSet<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> combination = new ArrayList<>();
		if (k > n) {
			return combination;
		}
		helper1(1, k, n, new ArrayList<>(), combination);
		return combination;
	}

	/**
	 * Complexity - O(k * 9^k)
	 * 
	 * Space - O(k)
	 */
	public void helper(int k, int n, List<Integer> currentCombination, List<List<Integer>> combination) {
		if (k == 0 && n == 0) {
			List<Integer> comb = new ArrayList<>(currentCombination);
			int sortedArray[] = new int[10];
			for (int val : comb) {
				sortedArray[val] = 1;
			}
			StringBuilder combinationString = new StringBuilder();
			for (int i = 1; i <= 9; i++) {
				if (sortedArray[i] == 1) {
					combinationString.append(i + "");
				}
			}
			if (!takenCombination.contains(combinationString.toString())) {
				combination.add(comb);
				takenCombination.add(combinationString.toString());
			}
			return;
		} else if (k > 0 && n > 0) {
			for (int i = 1; i <= 9; i++) {
				if (!currentCombination.contains(i)) {
					if (k - 1 == 0 && n - i != 0) {
						continue;
					}
					currentCombination.add(i);
					if (k - 1 >= 0 && n - i >= 0) {
						helper(k - 1, n - i, currentCombination, combination);
					}
					currentCombination.remove(currentCombination.size() - 1);
				}
			}
		}
	}

	/**
	 * Complexity - O(k * 9^k)
	 * 
	 * Space - O(k)
	 */
	public void helper1(int start, int k, int n, List<Integer> currentCombination, List<List<Integer>> combination) {
		if (currentCombination.size() == k && n == 0) {
			combination.add(new ArrayList<>(currentCombination));
			return;
		}
		for (int i = start; i <= 9; i++) {
			currentCombination.add(i);
			helper1(i + 1, k, n - i, currentCombination, combination);
			currentCombination.remove(currentCombination.size() - 1);
		}

	}

	public static void main(String[] args) {
		CombinationSumIII c = new CombinationSumIII();
		System.out.println(c.combinationSum3(9, 45));
	}

}
