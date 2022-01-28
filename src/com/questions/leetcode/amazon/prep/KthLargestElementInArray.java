package com.questions.leetcode.amazon.prep;

public class KthLargestElementInArray {

	public static int findKthLargest(int[] nums, int k) {
		return find(nums, 0, nums.length, nums.length - k);
	}

	public static int find(int[] nums, int beg, int end, int k) {
		// last index of elements lower than pivot
		int i = beg - 1;
		int pivot = nums[end - 1];

		for (int j = beg; j < end; j++) {
			if (nums[j] <= pivot) {
				// swap
				swap(nums, ++i, j);
			}
		}

		int pos = i;

		if (pos == k) {
			return nums[pos];
		} else if (pos > k) {
			return find(nums, beg, pos, k);
		} else {
			return find(nums, pos + 1, end, k);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int nums[] = { 3, 2, 1, 5, 6, 4 };
		System.out.println(findKthLargest(nums, 2));
	}

}
