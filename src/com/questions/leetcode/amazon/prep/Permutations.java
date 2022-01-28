package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		generatePermutations(0, nums, new ArrayList<>(), result);
		return result;
	}

	public static void generatePermutations(int index, int nums[], List<Integer> currentAnswer,
			List<List<Integer>> result) {
		System.out.println("Index : " + index + " Current Answer : " + currentAnswer + " Result : " + result);
		if (index == nums.length) {
			return;
		}
		if (currentAnswer.size() == nums.length) {
			result.add(new ArrayList<>(currentAnswer));
		} else {
			for (int i = 0; i < nums.length; i++) {
				currentAnswer.add(nums[i]);
				if (index != i) {
					generatePermutations(index + 1, nums, currentAnswer, result);
					currentAnswer.remove(currentAnswer.size() - 1);
					generatePermutations(index + 1, nums, currentAnswer, result);
				}
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		System.out.println(permute(nums));
	}

}
