package com.questions.leetcode.amazon.prep;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		int idx = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				idx++;
				int t = nums[i];
				nums[idx] = nums[i];
				nums[i] = t;
			}
		}
		return idx + 1;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 2 };
		System.out.println(removeDuplicates(nums));
	}

}
