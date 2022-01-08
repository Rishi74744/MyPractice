package com.questions.leetcode.algo1;

public class SearchInsert {

	public static int searchInsert(int[] nums, int target) {
		return search(0, nums.length - 1, nums, target);
	}

	public static int search(int start, int end, int nums[], int target) {
		if (start > end) {
			return -1;
		}
		if (nums[start] > target) {
			return start;
		}
		if (nums[end] < target) {
			return end + 1;
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid - 1;
		}
		if (nums[mid] < target && nums[mid + 1] >= target) {
			return mid + 1;
		}
		if (nums[mid] > target && nums[mid + 1] < target) {
			return mid - 1;
		}
		if (nums[mid] < target) {
			return search(mid + 1, end, nums, target);
		} else {
			return search(start, mid - 1, nums, target);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3 };
		int target = 2;
		System.out.println(searchInsert(nums, target));
	}

}
