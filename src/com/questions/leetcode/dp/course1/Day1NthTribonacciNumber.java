package com.questions.leetcode.dp.course1;

public class Day1NthTribonacciNumber {
	public static int tribonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2) {
			return 1;
		}
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		fib[2] = 1;
		for (int i = 3; i < n + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2] + fib[i - 3];
		}
		return fib[n];
	}

	public static void main(String[] args) {
		System.out.println(tribonacci(37));
	}
}
