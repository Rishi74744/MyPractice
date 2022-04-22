package com.java.prep.dp.linear;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 2
 * 
 * Explanation: There are two ways to climb to the top. 1. 1 step + 1 step 2. 2
 * steps
 * 
 * Example 2:
 * 
 * Input: n = 3 Output: 3
 * 
 * Explanation: There are three ways to climb to the top. 1. 1 step + 1 step + 1
 * step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * 
 * Constraints:
 * 
 * 1 <= n <= 45
 */
public class ClimbingStairs {

	/**
	 * Recurrence Relation - 1, if n==0 || n==1 f(n-1) + f(n-2), if n > 1
	 * 
	 * Complexity - O(n), Space - O(1)
	 */
	public int climbStairs(int n) {
		int step1 = 1;
		int step2 = 1;
		for (int i = 2; i <= n; i++) {
			step2 = step1 + step2;
			step1 = step2 - step1;
		}
		return step2;
	}

	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs(5));
	}

}
