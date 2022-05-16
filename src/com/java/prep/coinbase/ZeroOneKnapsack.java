package com.java.prep.coinbase;

public class ZeroOneKnapsack {

	/**
	 * Complexity - O(2^n), Space - O(1)
	 */
	public int knapsackWithOptimalSubset(int requiredWeight, int[] weights, int[] profits, int totalRes) {
		if (totalRes == 0 || requiredWeight == 0) {
			return 0;
		}
		if (weights[totalRes - 1] > requiredWeight) {
			return knapsackWithOptimalSubset(requiredWeight, weights, profits, totalRes - 1);
		} else {
			return Math.max(
					profits[totalRes - 1] + knapsackWithOptimalSubset(requiredWeight - weights[totalRes - 1], weights,
							profits, totalRes - 1),
					knapsackWithOptimalSubset(requiredWeight, weights, profits, totalRes - 1));
		}
	}

	public int knapsackWithDP(int requiredWeight, int[] weights, int[] profits, int totalRes) {
		int dp[][] = new int[totalRes + 1][requiredWeight + 1];
		for (int i = 0; i <= totalRes; i++) {
			for (int j = 0; j <= requiredWeight; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (weights[i - 1] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + profits[i - 1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[totalRes][requiredWeight];
	}

	public static void main(String[] args) {
		ZeroOneKnapsack z = new ZeroOneKnapsack();
		int p[] = { 1, 2, 5, 6 };
		int w[] = { 2, 3, 4, 4 };
		System.out.println(z.knapsackWithOptimalSubset(8, w, p, 4));
		System.out.println(z.knapsackWithDP(8, w, p, 4));
	}
}
