package com.questions.leetcode.easy.dp;

public class FibonacciNumber {

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static int fibwithloop(int n) {
		int fib[] = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	public static void main(String[] args) {
		System.out.println(fib(4));
		System.out.println(fibwithloop(4));
	}
}
