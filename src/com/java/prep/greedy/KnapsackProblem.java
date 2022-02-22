package com.java.prep.greedy;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class KnapsackProblem {

	private static double getProfit(int profit[], int weight[], int n, int m) {
		Map<Integer, Double> profitWeightRatio = new HashMap<>();
		for (int i = 0; i < n; i++) {
			profitWeightRatio.put(i, ((double) profit[i] / (double) weight[i]));
		}
		int totalWeight = 0;
		double totalProfit = 0.0;
		profitWeightRatio = profitWeightRatio.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
		for (Entry<Integer, Double> knapsackEntry : profitWeightRatio.entrySet()) {
			int previousWeight = totalWeight;
			totalWeight += weight[knapsackEntry.getKey()];
			if (totalWeight > m) {
				totalProfit += (((double) (m - previousWeight) / (double) weight[knapsackEntry.getKey()])
						* profit[knapsackEntry.getKey()]);
				break;
			} else if (totalWeight == m) {
				totalProfit += profit[knapsackEntry.getKey()];
				break;
			} else {
				totalProfit += profit[knapsackEntry.getKey()];
			}
		}
		return totalProfit;
	}

	public static void main(String[] args) {
		int profit[] = { 75, 15, 80, 40, 25, 95, 50 };
		int weight[] = { 15, 3, 16, 8, 3, 16, 6 };
		double knapsackProfit = getProfit(profit, weight, 7, 55);
		System.out.println(knapsackProfit);
	}

}
