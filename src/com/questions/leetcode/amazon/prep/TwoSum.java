package com.questions.leetcode.amazon.prep;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSumBruteForce(int[] nums, int target) {
		int result[] = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		return result;
	}

	public static int[] twoSum(int[] nums, int target) {
		int result[] = new int[2];
		Map<Integer, Integer> diffMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (diffMap.containsKey(diff)) {
				result[0] = diffMap.get(diff);
				result[1] = i;
				break;
			}
			diffMap.put(nums[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15 };
		int result[] = twoSumBruteForce(nums, 9);
		for (int i : result) {
			System.out.print(i + " ");
		}

		int result2[] = twoSum(nums, 13);
		for (int i : result2) {
			System.out.print(i + " ");
		}
	}

}
