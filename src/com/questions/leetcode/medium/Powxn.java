package com.questions.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Powxn {

	public static Map<Integer, Double> memoize = new HashMap<>();

	public static double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n == -1) {
			return 1 / x;
		}
		if (memoize.containsKey(n)) {
			return memoize.get(n);
		} else {
			int mid = n / 2;
			double leftResult = myPow(x, mid);
			double rightResult = myPow(x, n - mid);
			double pow = leftResult * rightResult;
			memoize.put(n, pow);
			return pow;
		}
	}

	public static void main(String[] args) {
		System.out.println(myPow(2.10000, 3));
	}

}
