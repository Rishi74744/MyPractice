package com.questions.leetcode.amazon.prep;

public class NumberOfStepsToReduceANumberToZero {

	public static int numberOfSteps(int num) {
		if (num == 0) {
			return 0;
		}
		return findSteps(num, 0);
	}

	static int findSteps(int num, int steps) {
		if (num == 0) {
			return steps;
		} else {
			if (num % 2 == 0) {
				return findSteps(num / 2, steps + 1);
			} else {
				return findSteps(num - 1, steps + 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(numberOfSteps(124));
	}

}
