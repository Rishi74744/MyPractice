package com.questions.leetcode.dp.course1;

public class Day7BestTimeToBuyAndSellStockWithTransactionFee {

	public static int maxProfit(int[] prices, int fee) {
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int min = prices[0];
		int profit = 0;
		int currentProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			int indexProfit = prices[i] - min - fee;
			if (currentProfit < indexProfit) {
				currentProfit = indexProfit;
			} else {
				profit += currentProfit;
				min = prices[i];
				currentProfit = 0;
			}
		}
		if (currentProfit > 0) {
			profit += currentProfit;
		}
		return profit;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		System.out.println(maxProfit(nums, fee));
	}

}
