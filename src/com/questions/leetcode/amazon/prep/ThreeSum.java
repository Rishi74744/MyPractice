package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Set<String> unique = new HashSet<>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> answer = new ArrayList<>();
						unique.add(nums[i] + "" + nums[j] + "" + nums[k]);
					}
				}
			}
		}
		for (String s : unique) {
			List<Integer> answer = new ArrayList<>();
			String num[] = s.split("");
			for (String n : num) {
				answer.add(Integer.valueOf(n));
			}
			result.add(answer);
		}

		return result;
	}

	public static void main(String[] args) {
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
	}

}
