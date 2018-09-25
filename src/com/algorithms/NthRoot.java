package com.algorithms;

public class NthRoot {

	static double findNthRoot(int a, int n) {
		double xPre = Math.random() % 10;
		double eps = 0.001;
		double delX = 2147483647;
		double xK = 0.0;
		while (delX > eps) {
			xK = ((n - 1.0) * xPre + (double) (a / Math.pow(xPre, n - 1))) / (double) n;
			delX = Math.abs(xK - xPre);
			xPre = xK;
		}
		return xK;
	}

	static double nthRoot(int A, int N) {
		double xPre = Math.random() % 10;
		double eps = 0.001;
		double delX = 2147483647;
		double xK = 0.0;

		while (delX > eps) {
			// calculating current value from previous
			// value by newton's method
			xK = ((N - 1.0) * xPre + (double) A / Math.pow(xPre, N - 1)) / (double) N;
			delX = Math.abs(xK - xPre);
			xPre = xK;
		}

		return xK;
	}

	public static void main(String[] args) {
		System.out.println(Math.floor(findNthRoot(10, 2)));
		System.out.println(nthRoot(81, 4));
	}

}