package com.questions.leetcode.amazon.prep;

public class CoinChange {

	public static int coinChange(int[] coins, int amount) {
		int m[][] = new int[coins.length + 1][amount];
		
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < amount; j++) {
				if (coins[i] > j) {
					m[i][j] = m[i - 1][j];
				} else {
					m[i][j] = Math.min(m[i - 1][j], 1 + m[i][j - coins[i]]);
				}
			}
		}
		return m[coins.length - 1][amount - 1];
	}

	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		System.out.println(coinChange(coins, 11));
	}

}
