
package com.java.prep.arrays;

public class BestTimeToBuyAndSellStockIII {

	public static int maxProfit(int[] prices) {
		if (prices.length == 1) {
			return 0;
		}
		int profit = 0;
		int lastProfit = 0;
		int currentProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				currentProfit = profit;
				profit += (prices[i] - prices[i - 1]);
			} else {
				System.out.println("Cool Down at : " + i);
				lastProfit = Math.max(lastProfit, profit);
				profit = currentProfit;
			}
		}
		return lastProfit;
	}

	public static void main(String[] args) {
		int prices[] = { 1, 8, 0, 5 };
		System.out.println(maxProfit(prices));
	}

}
