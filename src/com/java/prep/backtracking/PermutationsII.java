package com.java.prep.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2]
 * 
 * Output: [[1,1,2], [1,2,1], [2,1,1]]
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 8
 * 
 * -10 <= nums[i] <= 10
 */
public class PermutationsII {

	List<List<Integer>> result = new ArrayList<>();

	/**
	 * Time Complexity: O(N * N!). Number of permutations = P(N,N) = N!. Each
	 * permutation takes O(N) to construct
	 *
	 * T(n) = n*T(n-1) + O(n) T(n-1) = (n-1)*T(n-2) + O(n) ... T(2) = (2)*T(1) +
	 * O(n) T(1) = O(n)
	 *
	 * Above equations can be added together to get: T(n) = n (1 + n + n*(n-1) + ...
	 * + (n....2) + (n....1)) = n (P(n,0) + P(n,1) + P(n,1) + ... + P(n,n-1) +
	 * P(n,n)) = n * Floor(e*n!) = O(N * N!)
	 * 
	 * O(N * N!) + O(NlogN)
	 * 
	 * Space - O(N)
	 * 
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		// sort the array
		Arrays.sort(nums); // O(NlogN)

		// call the recursive method to get the result.
		helper(nums, new ArrayList<>(), new ArrayList<>()); // O(N * N!)
		return result;
	}

	public void helper(int nums[], List<Integer> currentPermute, List<Integer> indexIncluded) {
		if (currentPermute.size() == nums.length) {
			result.add(new ArrayList<>(currentPermute));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (indexIncluded.contains(i) || (i > 0 && !indexIncluded.contains(i - 1) && nums[i] == nums[i - 1])) {
				continue;
			}
			indexIncluded.add(i);
			currentPermute.add(nums[i]);
			helper(nums, currentPermute, indexIncluded);
			currentPermute.remove(currentPermute.size() - 1);
			indexIncluded.remove(indexIncluded.size() - 1);
		}
	}

	/**
	 * Complexity - O(N * N!)
	 * 
	 * Space - O(N)
	 */
	public List<List<Integer>> permuteUnique1(int[] nums) {
		helper(nums, new ArrayList<>(), new ArrayList<>());
		return result;
	}

	public void helper1(int nums[], List<Integer> currentPermute, List<Integer> indexIncluded) {
		if (currentPermute.size() == nums.length) {
			result.add(new ArrayList<>(currentPermute));
			return;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (indexIncluded.contains(i)) {
				continue;
			}
			if (set.contains(nums[i])) {
				continue;
			}
			set.add(nums[i]);
			indexIncluded.add(i);
			currentPermute.add(nums[i]);
			helper(nums, currentPermute, indexIncluded);
			currentPermute.remove(currentPermute.size() - 1);
			indexIncluded.remove(indexIncluded.size() - 1);
		}
	}

	public static void main(String[] args) {
		PermutationsII p = new PermutationsII();
		int[] nums = { 3, 3, 0, 3 };
		System.out.println(p.permuteUnique(nums));
	}

}
