package com.questions.leetcode.dp.course1;

public class Day1FibonnaciNumber {
	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	public static void main(String[] args) {
		System.out.println(fib(4));
	}
}
