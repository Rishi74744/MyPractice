package com.questions.leetcode.dp.course1;

public class Day4JumpGame {

	public static boolean canJump(int[] nums) {
		int reachedAt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (reachedAt < i) {
				return false;
			}
			int currentReach = i + nums[i];
			if (currentReach > reachedAt) {
				reachedAt = currentReach;
			}
			if (reachedAt >= nums.length) {
				return true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int nums1[] = { 0, 0, 1, 2, 0 };
		int nums2[] = { 3, 2, 1, 0, 4 };
		int nums3[] = { 1, 0, 1, 0 };
		int nums4[] = { 1 };
		int nums5[] = { 0 };
		int nums6[] = { 2, 0 };
		System.out.println(canJump(nums1));
		System.out.println(canJump(nums2));
		System.out.println(canJump(nums3));
		System.out.println(canJump(nums4));
		System.out.println(canJump(nums5));
		System.out.println(canJump(nums6));
	}

}
