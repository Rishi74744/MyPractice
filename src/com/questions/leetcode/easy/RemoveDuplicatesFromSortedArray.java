package com.questions.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		int k = 1;
		int last = -101;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != last) {
				last = nums[i];
				k++;
			} else {
				nums[i] = nums[i + 1];
				i++;
			}
		}
		return k;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
//		int arr[] = { 1, 1, 2 };
		System.out.println(removeDuplicates(arr));
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
