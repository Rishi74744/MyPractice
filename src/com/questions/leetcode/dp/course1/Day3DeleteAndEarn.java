package com.questions.leetcode.dp.course1;

public class Day3DeleteAndEarn {

	public static int deleteAndEarn(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		int bucket[] = new int[max + 1];
		for (int i = 0; i < nums.length; i++) {
			bucket[nums[i]] += nums[i];
		}
		return process(bucket);
	}

	public static int process(int nums[]) {
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
		int nums[] = { 2, 2, 3, 3, 3, 4 };
		System.out.println(deleteAndEarn(nums));
	}

}
