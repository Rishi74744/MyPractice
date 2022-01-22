package com.questions.randomquestions;

public class ZeroOneKnapsack {

	public static int zeroOneKnapSack(int weights[], int profits[], int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (weights[n - 1] > m) {
			return zeroOneKnapSack(weights, profits, n - 1, m);
		} else {
			return Math.max(zeroOneKnapSack(weights, profits, n - 1, m),
					zeroOneKnapSack(weights, profits, n - 1, m - weights[n - 1]) + profits[n - 1]);
		}
	}

	public static void main(String[] args) {
		int profits[] = { 25, 15, 40, 50, 50, 16, 20 };
		int weights[] = { 8, 5, 9, 3, 2, 7, 3 };
		System.out.println(zeroOneKnapSack(weights, profits, weights.length, 20));
	}

}
