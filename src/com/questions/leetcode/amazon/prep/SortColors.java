package com.questions.leetcode.amazon.prep;

public class SortColors {

	public static void sortColors(int[] nums) {
		int count[] = new int[3];
		int sorted[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			sorted[count[nums[i]] - 1] = nums[i];
			count[nums[i]]--;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sorted[i];
		}
	}

	public static void main(String[] args) {
		int n[] = { 2, 0, 2, 1, 1, 0 };
		sortColors(n);
	}

}
