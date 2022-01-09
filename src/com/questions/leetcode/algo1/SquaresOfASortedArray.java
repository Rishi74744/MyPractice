package com.questions.leetcode.algo1;

import java.util.Arrays;

public class SquaresOfASortedArray {

	public static int[] sortedSquares(int[] nums) {
		int squaredNums[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			squaredNums[i] = nums[i] * nums[i];
		}

		Arrays.sort(squaredNums);
		return squaredNums;
	}

	public static void main(String[] args) {
		int nums[] = { -7, -3, 2, 3, 11 };
		int result[] = sortedSquares(nums);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
