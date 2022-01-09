package com.questions.leetcode.dp.course1;

public class Day5MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int currMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (currMax < 0) {
				currMax = 0;
			}
			currMax += nums[i];
			max = Math.max(max, currMax);
		}
		return max;
	}

	public static void main(String[] args) {
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}
}
