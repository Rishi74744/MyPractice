
package com.questions.leetcode.dp.course1;

public class Day7BestTimeToBuyAndSellStock2 {

	public static int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += (prices[i] - prices[i - 1]);
			}

		}
		return profit;
	}

	public static void main(String[] args) {
		int prices[] = { 3, 2, 6, 5, 0, 3 };
		System.out.println(maxProfit(prices));
	}

}
