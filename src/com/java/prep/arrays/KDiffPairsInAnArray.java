package com.java.prep.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers nums and an integer k, return the number of unique
 * k-diff pairs in the array.
 * 
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are
 * true:
 * 
 * 0 <= i, j < nums.length
 * 
 * i != j
 * 
 * nums[i] - nums[j] == k
 * 
 * Notice that |val| denotes the absolute value of val.
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,4,1,5], k = 2 Output: 2
 * 
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of
 * unique pairs.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,4,5], k = 1 Output: 4
 * 
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4)
 * and (4, 5). Example 3:
 * 
 * Input: nums = [1,3,1,5,4], k = 0 Output: 1
 * 
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10^4
 * 
 * -10^7 <= nums[i] <= 10^7
 * 
 * 0 <= k <= 10^7
 */
public class KDiffPairsInAnArray {

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public int findPairs(int[] nums, int k) {
		int result = 0;
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		for (int i : nums) {
			count.put(i, count.getOrDefault(i, 0) + 1);
		}
		for (int i : count.keySet()) {
			if (k > 0 && count.containsKey(i + k)) {
				pairs.put(i, i + k);
				result++;
			} else if (k == 0 && count.get(i) > 1) {
				pairs.put(i, i);
				result++;
			}
		}
		System.out.println(pairs);
		return result;
	}

	public static void main(String[] args) {
		KDiffPairsInAnArray k = new KDiffPairsInAnArray();
		int nums[] = { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 };
		System.out.println(k.findPairs(nums, 3));
	}

}
