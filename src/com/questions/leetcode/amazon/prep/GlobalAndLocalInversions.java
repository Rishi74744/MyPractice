package com.questions.leetcode.amazon.prep;

public class GlobalAndLocalInversions {

	public boolean isIdealPermutation(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return true;
		}
		int val = nums[0];
		for (int i = 2; i < n; i++) {
			if (nums[i] < val) {
				return false;
			}
			val = Math.max(val, nums[i - 1]);
		}
		return true;
	}

}