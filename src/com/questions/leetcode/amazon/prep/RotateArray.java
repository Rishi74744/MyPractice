package com.questions.leetcode.amazon.prep;

public class RotateArray {

	public static void rotate(int[] nums, int k) {
		int arr[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[(i + k) % nums.length] = arr[i];
		}
	}

	public static void rotate1(int[] nums, int k) {
		int n = nums.length;
		if (k > n) {
			k = k % n;
		}
		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);
		reverse(nums, 0, n - 1);
	}

	public static void reverse(int nums[], int i, int j) {
		while (i < j) {
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate1(nums, 3);
		for (int i : nums) {
			System.out.print(i + ",");
		}
	}

}
