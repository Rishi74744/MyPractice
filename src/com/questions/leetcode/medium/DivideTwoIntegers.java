package com.questions.leetcode.medium;

public class DivideTwoIntegers {

	public static int divide(int dividend, int divisor) {
		int quotient = 0;
		int defaultValueHigh = (int) Math.pow(2, 31);
		int defaultValueLow = ((int) Math.pow(2, 31) * -1) - 1;
		if (divisor == 1 || divisor == -1) {
			quotient = dividend * divisor;
			if (quotient >= defaultValueHigh) {
				return defaultValueHigh;
			} else if (quotient <= defaultValueLow) {
				return defaultValueLow;
			}
			return quotient;
		}
		int absDivisor = Math.abs(divisor);
		int absDividend = Math.abs(dividend);
		while ((absDividend - absDivisor) >= 0) {
			absDividend = absDividend - absDivisor;
			quotient++;
		}
		if ((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
			quotient *= -1;
		}
		if (quotient > defaultValueHigh || quotient < defaultValueLow) {
			if (quotient >= defaultValueHigh) {
				return defaultValueHigh;
			} else if (quotient <= defaultValueLow) {
				return defaultValueLow;
			}
		}
		return quotient;
	}

	public static void main(String[] args) {
		System.out.println(divide(-2147483648, -1));
	}

}
