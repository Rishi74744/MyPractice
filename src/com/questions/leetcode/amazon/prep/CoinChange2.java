package com.questions.leetcode.amazon.prep;

public class CoinChange2 {

	public static int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < dp.length; j++) {
				dp[j] = dp[j] + dp[j - coins[i]];
			}
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		System.out.println(change(5, coins));
	}

}
