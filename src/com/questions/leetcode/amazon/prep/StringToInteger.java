package com.questions.leetcode.amazon.prep;

public class StringToInteger {

	public static int myAtoi(String s) {
		if (s == null || s.trim().isEmpty()) {
			return 0;
		}
		char a[] = s.trim().toCharArray();
		int number = 0;
		int sign = 1;
		int i = 0;
		if (a[0] == '-') {
			sign = -1;
			i = 1;
		} else if (a[0] == '+') {
			sign = 1;
			i = 1;
		}
		for (; i < a.length; i++) {
			if (a[i] >= 48 && a[i] <= 57) {
				int numericValue = Character.getNumericValue(a[i]);
				long updateValue = number * 10L + numericValue;
				if (sign * updateValue <= Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				} else if (sign * updateValue >= Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else {
					number = number * 10 + numericValue;
				}
			} else {
				break;
			}
		}
		return sign * number;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("  32.184984981984984978 is a word"));
	}

}
