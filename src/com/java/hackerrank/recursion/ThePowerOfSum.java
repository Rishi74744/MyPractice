package com.java.hackerrank.recursion;

public class ThePowerOfSum {

	static int powerSum(int X, int N) {
		int nth = (int) Math.round(Math.floor(Math.pow(X, 1.0 / N)));
		int result = 0;
		int arr[] = new int[nth + 1];
		for (int i = 1; i <= nth; i++) {
			arr[i] = (int) Math.pow(i, N);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(powerSum(100, 2));
	}

}