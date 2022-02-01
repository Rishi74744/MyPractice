package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int low = i + 1;
			int high = nums.length - 1;
			while (low < high) {
				if (nums[i] + nums[low] + nums[high] == 0) {
					result.add(Arrays.asList(nums[i], nums[low], nums[high]));
					low++;
					high--;
					while (high > low && nums[low - 1] == nums[low]) {
						low++;
					}
					while (high > low && nums[high + 1] == nums[high]) {
						high--;
					}
				} else if (nums[i] + nums[low] + nums[high] > 0) {
					high--;
				} else {
					low++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
	}

}
