package com.questions.randomquestions;

public class ReverseNumber {

	private static int reverse(int A) {
		long rev = 0;
		while (A != 0) {
			int r = A % 10;
			rev = rev * 10 + r;
			A = A / 10;
		}
		return (int) rev;
	}

	public static void main(String[] args) {
		// System.out.println(Integer.MIN_VALUE);
		// System.out.println(Integer.MAX_VALUE);
		System.err.println(reverse(-1146467285));
	}

}
