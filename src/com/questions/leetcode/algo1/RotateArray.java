package com.questions.leetcode.algo1;

public class RotateArray {

	public static void rotate(int[] nums, int k) {
		int rotatedArr[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int idx = i + k;
			if (idx > nums.length - 1) {
				idx = idx - (nums.length - 1);
			}
			rotatedArr[idx] = nums[i];
		}
		nums = rotatedArr;
	}

	public static void rotate1(int nums[], int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 3; j < nums.length; j = j + 3) {
				
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
