package com.questions.leetcode.dp.course1;

import java.util.Arrays;

public class Day3HouseRobber2 {

	public static int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] array1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
		int[] array2 = Arrays.copyOfRange(nums, 1, nums.length);
		return Math.max(robHouses(array1), robHouses(array2));
	}

	public static int robHouses(int nums[]) {
		int maxRob = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			if (i < nums.length - 2) {
				if (i == nums.length - 3) {
					nums[i] += nums[i + 2];
				} else {
					nums[i] += Math.max(nums[i + 2], nums[i + 3]);
				}
			}
			if (maxRob < nums[i]) {
				maxRob = nums[i];
			}
		}
		return maxRob;
	}

	public static void main(String[] args) {
		int nums[] = { 2, 3, 2 };
		System.out.println(rob(nums));
	}

}
