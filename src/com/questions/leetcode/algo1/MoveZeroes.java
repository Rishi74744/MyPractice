package com.questions.leetcode.algo1;

public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		int zeroAt = -1;
		boolean isZero = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (!isZero) {
					zeroAt = i;
					isZero = true;
				}
			} else {
				if (isZero) {
					isZero = false;
					nums[zeroAt] = nums[i];
					nums[i] = 0;
					i = zeroAt;
					zeroAt = i;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
