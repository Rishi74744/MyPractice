package com.questions.randomquestions;

public class PallindromeInteger {

	private static int reverse(int A) {
		if (A < 0) {
			return 0;
		}
		int num = A;
		long rev = 0;
		while (A != 0) {
			int r = A % 10;
			rev = rev * 10 + r;
			A = A / 10;
		}
		return ((int) rev == num) ? 1 : 0;
	}

	public static void main(String[] args) {
		System.err.println(reverse(-2147447412));
	}

}
