package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		generateSubsets(0, nums, new ArrayList<>(), result);
		return result;
	}

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
