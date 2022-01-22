package com.questions.leetcode.dp.course1;

public class Day7BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		int profitToday = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			profitToday = prices[i] - min;
			if (profitToday > maxProfit) {
				maxProfit = profitToday;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int prices[] = { 4, 4, 8, 3, 2, 4, 9, 12, 3, 18, 1 };
		System.out.println(maxProfit(prices));
	}

}
