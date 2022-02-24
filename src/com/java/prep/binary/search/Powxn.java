package com.java.prep.binary.search;

public class Powxn {

	/**
	 * Complexity - O(logn), Space - O(logn)
	 */
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		return calculate(x, n);
	}

	double calculate(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		double res = calculate(x, n / 2);
		return n % 2 == 0 ? res * res : res * res * x;
	}

	/**
	 * Complexity - O(logn), Space - O(1)
	 */
	public double myPowIterative(double x, int N) {
		long n = N;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		double ans = 1;
		double curr = x;
		for (long i = n; i > 0; i /= 2) {
			if ((i % 2) == 1) {
				ans = ans * curr;
			}
			curr = curr * curr;
		}
		return ans;
	}

	public static void main(String[] args) {
		Powxn p = new Powxn();
		System.out.println(p.myPow(-2.00000, -3));
	}

}
