package com.questions.leetcode.amazon.prep;

public class TwoSumIIInputIsSorted {

	public static int[] twoSum(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				return new int[] { i + 1, j + 1 };
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int number[] = { 2, 7, 11, 15 };
		int result[] = twoSum(number, 9);
		System.out.println(result[0] + ", " + result[1]);
	}

}
