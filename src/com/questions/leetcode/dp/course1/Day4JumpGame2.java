package com.questions.leetcode.dp.course1;

public class Day4JumpGame2 {

	public static int jump(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		int step = 1;
		int maxReach = 0;
		int currentReach = nums[0];
		int maxIndex = 0;
		if (currentReach >= nums.length - 1) {
			return step;
		}
		for (int i = 1; i < nums.length; i++) {
			int indexReach = i + nums[i];
			if (maxReach < indexReach) {
				maxReach = indexReach;
				maxIndex = i;
			}
			if (i == currentReach) {
				step++;
				if (maxReach >= nums.length - 1) {
					break;
				} else {
					currentReach = maxReach;
				}
			}
		}
		return step;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 1, 1, 1 };
		int nums1[] = { 7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3 };
		int nums3[] = { 2, 3, 1, 1, 4 };
//		int nums2[] = { 2, 3, 0, 1, 4 };
//		int nums3[] = { 5, 1, 1, 1, 2, 4, 6, 0, 0, 0, 0, 4 };
		int nums4[] = { 1 };
		int nums5[] = { 0 };
//		int nums6[] = { 2, 0 };
//		System.out.println(jump(nums1));
//		System.out.println(jump(nums2));
		System.out.println(jump(nums3));
		System.out.println(jump(nums4));
		System.out.println(jump(nums5));
//		System.out.println(jump(nums6));
		System.out.println(jump(nums));
		System.out.println(jump(nums1));
	}

}
