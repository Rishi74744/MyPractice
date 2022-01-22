package com.questions.leetcode.amazon.prep;

public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - min);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int prices[] = {};
		System.out.println(maxProfit(prices));
	}

}
