package com.questions.leetcode.dp.course1;

public class Day6MaximumProductSubarray {

	public static int maxProduct(int[] nums) {
		int max = nums[0];
		int currMax = 1;
		for (int i = 0; i < nums.length; i++) {
			if (currMax < 0) {
				currMax = 0;
			}
			currMax *= nums[i];
			max = Math.max(max, currMax);
		}
		return max;
	}

	public static void main(String[] args) {
		int nums[] = { -3, -1, 1 };
		System.out.println(maxProduct(nums));
	}

}
