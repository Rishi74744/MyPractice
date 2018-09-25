package com.java.hackerrank.recursion;

public class ThePowerOfSum {

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
	
	public static void main(String[] args) {

	}

}