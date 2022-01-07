package com.java.geeksforgeeks.amazon;

import java.util.ArrayList;
import java.util.List;

public class NumberOfSubsetWithProductLessThanK {

	public static List<List<Integer>> subsets(int nums[]) {
		List<List<Integer>> subsets = new ArrayList<>();
		generateSubset(0, nums, new ArrayList<Integer>(), subsets);
		return subsets;
	}

	public static void generateSubset(int index, int nums[], List<Integer> current, List<List<Integer>> subsets) {
		subsets.add(new ArrayList<>(current));
		for (int i = index; i < nums.length; i++) {
			current.add(nums[i]);
			generateSubset(i + 1, nums, current, subsets);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		int nums[] = { 2, 4, 5, 1 };
		System.out.println(subsets(nums));
	}

}
