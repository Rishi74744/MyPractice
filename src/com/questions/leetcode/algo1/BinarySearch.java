package com.questions.leetcode.algo1;

public class BinarySearch {

	public static int search(int[] nums, int target) {
		return binarySearch(0, nums.length - 1, nums, target);
	}

	public static int binarySearch(int start, int end, int nums[], int target) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (nums[mid] > target) {
			return binarySearch(start, mid - 1, nums, target);
		} else {
			return binarySearch(mid + 1, end, nums, target);
		}
	}

	public static void main(String[] args) {
		int nums[] = {};
		int target = 9;
		System.out.println(search(nums, target));
	}

}
