package com.questions.leetcode.amazon.prep;

public class MonotoneIncreasingDigits {

	public static int monotoneIncreasingDigits(int n) {
		int i = 10;
		while (n / i > 0) {
			int digit = (n / i) % 10;
			int endNum = n % i;
			int firstEnd = endNum * 10 / i;
			if (digit > firstEnd) {
				n -= endNum + 1;
			}
			i *= 10;
			System.out.println(n);
		}
		System.out.println("-----Result-----");
		return n;

	}

	public static void main(String[] args) {
		System.out.println(monotoneIncreasingDigits(332));
	}

}
