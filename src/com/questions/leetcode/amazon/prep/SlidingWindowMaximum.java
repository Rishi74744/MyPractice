package com.questions.leetcode.amazon.prep;

public class SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n < k) {
			return new int[] {};
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		int result[] = new int[n - k + 1];
		for (int i = 0; i < k; i++) {
			if (max < nums[i]) {
				maxIndex = i;
				max = nums[i];
			}
		}
		result[0] = max;
		int j = 1;
		for (int i = k; i < nums.length; i++) {
			if (i - k + 1 <= maxIndex && maxIndex <= i) {
				if (max < nums[i]) {
					max = nums[i];
					maxIndex = i;
				}
			} else {
				max = Integer.MIN_VALUE;
				for (int l = i; l >= (i - k + 1); l--) {
					if (max < nums[l]) {
						maxIndex = l;
						max = nums[l];
					}
				}
			}
			result[j] = max;
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] result = maxSlidingWindow(nums, 3);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
