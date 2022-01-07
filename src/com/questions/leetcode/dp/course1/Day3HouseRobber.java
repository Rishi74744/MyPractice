package com.questions.leetcode.dp.course1;

public class Day3HouseRobber {

	public static int rob(int[] nums) {
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
		int nums[] = { 2, 1, 1, 2 };
		System.out.println(rob(nums));
	}

}
