package com.questions.leetcode.dp.course1;

public class Day2ClimbStairs {

	public static int climbStairs(int n) {
		int stairs[] = new int[n + 1];
		stairs[0] = 1;
		stairs[1] = 1;
		for (int i = 2; i <= n; i++) {
			stairs[i] = stairs[i - 1] + stairs[i - 2];
		}
		return stairs[n];
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(10));
	}

}
