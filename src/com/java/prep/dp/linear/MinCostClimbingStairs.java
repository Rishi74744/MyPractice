package com.java.prep.dp.linear;

import java.util.Arrays;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * 
 * Example 1:
 * 
 * Input: cost = [10,15,20] Output: 15
 * 
 * Explanation: You will start at index 1. - Pay 15 and climb two steps to reach
 * the top. The total cost is 15.
 * 
 * Example 2:
 * 
 * Input: cost = [1,100,1,1,1,100,1,1,100,1] Output: 6
 * 
 * Explanation: You will start at index 0. - Pay 1 and climb two steps to reach
 * index 2. - Pay 1 and climb two steps to reach index 4. - Pay 1 and climb two
 * steps to reach index 6. - Pay 1 and climb one step to reach index 7. - Pay 1
 * and climb two steps to reach index 9. - Pay 1 and climb one step to reach the
 * top. The total cost is 6.
 * 
 * 
 * Constraints:
 * 
 * 2 <= cost.length <= 1000
 * 
 * 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs {

	/**
	 * DP approach
	 * 
	 * Recurrence Relation -
	 * 
	 * 0, if n == 0
	 * 
	 * cost + min(f(n-1), f(n-2), if n >= 2
	 * 
	 * Complexity - O(n), Space - O(1)
	 * 
	 */
	public int minCostClimbingStairs(int[] cost) {
		int step1 = 0;
		int step2 = 0;
		for (int i = cost.length - 1; i >= 0; i--) {
			int currentStep = cost[i] + Math.min(step1, step2);
			step1 = step2;
			step2 = currentStep;
		}
		return Math.min(step1, step2);
	}

	/**
	 * Greedy Approach
	 * 
	 * Complexity - O(n), Space - O(1)
	 * 
	 */
	public int minCostClimbingStairsWithGreedy(int[] cost) {
		if (cost.length == 1) {
			return 0;
		}
		for (int i = 2; i < cost.length; i++) {
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}
		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}

	public static void main(String[] args) {
		MinCostClimbingStairs m = new MinCostClimbingStairs();
		int cost[] = { 10, 15 };
		System.out.println(m.minCostClimbingStairs(cost));
		System.out.println(m.minCostClimbingStairsWithGreedy(cost));
	}

}
