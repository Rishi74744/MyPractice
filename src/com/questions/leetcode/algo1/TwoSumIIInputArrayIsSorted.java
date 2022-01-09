package com.questions.leetcode.algo1;

public class TwoSumIIInputArrayIsSorted {

	public static int[] twoSum(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length - 1;
		int result[] = new int[2];
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				result[0] = i + 1;
				result[1] = j + 1;
				return result;
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}
		result[0] = i + 1;
		result[1] = j + 1;
		return result;
	}

	public static void main(String[] args) {
		int[] numbers = { -1, 0 };
		int target = -1;
		int result[] = twoSum(numbers, target);
		System.out.println(result[0] + " - " + result[1]);
	}
}
