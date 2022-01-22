package com.questions.leetcode.dp.course1;

public class Day5MaximumSumCircularSubarray {

	public static int maxSubarraySumCircular(int nums[]) {
		int currentMax = 0;
		int max = nums[0];
		for (int i = -1; i < nums.length; i++) {
			int idx = (i + 1) % nums.length;
			if ((currentMax + nums[idx]) < currentMax) {
				currentMax = nums[idx];
			} else {
				currentMax += nums[idx];
			}
			max = Math.max(max, currentMax);
			System.out.println("Index : " + idx + ", Current Max: " + currentMax + " Max: " + max);
		}
		System.out.println("--------------------------------------");
		return max;
	}

	public static void main(String[] args) {
		int nums[] = { 1, -2, 3, -2 };

		System.out.println(maxSubarraySumCircular(nums));
	}

}
