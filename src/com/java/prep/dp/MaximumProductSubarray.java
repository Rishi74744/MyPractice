package com.java.prep.dp;

public class MaximumProductSubarray {

	public static int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		int max1 = 1;
		int max2 = 1;
		for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
			max1 = max1 == 0 ? 1 : max1;
			max2 = max2 == 0 ? 1 : max2;

			max1 = max1 * nums[i];
			max2 = max2 * nums[j];
			max = Math.max(max, Math.max(max1, max2));
		}
		return max;
	}

	public static void main(String[] args) {
		int nums[] = { -2 };
		System.out.println(maxProduct(nums));
	}

}
