package com.java.prep.math;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * 
 * Repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1.
 * 
 * Those numbers for which this process ends in 1 are happy. Return true if n is
 * a happy number, and false if not.
 *
 * 
 * Example 1: Input: n = 19 Output: true
 * 
 * Example 2: Input: n = 2 Output: false
 *
 * Constraints: 1 <= n <= 231 - 1
 *
 */

public class HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> nums = new HashSet<>();
		nums.add(n);
		while (n != 1) {
			n = findSquaredSum(n);
			if (nums.contains(n)) {
				return false;
			}
			nums.add(n);
		}
		return true;
	}

	public boolean isHappyFaster(int n) {
		int fast = n;
		int slow = n;
		do {
			fast = findSquaredSum(findSquaredSum(fast));
			slow = findSquaredSum(slow);
		} while (fast != slow);
		return slow == 1;
	}

	private int findSquaredSum(int n) {
		int squaredSum = 0;
		while (n != 0) {
			int r = n % 10;
			squaredSum += (int) Math.pow(r, 2);
			n /= 10;
		}
		return squaredSum;
	}

	/**
	 * Complexity for Approach 1 using Hashset - O(n), Space - O(n)
	 * 
	 * Complexity for Approach 2 - O(n), Space - O(1)
	 * 
	 */

	public static void main(String[] args) {
		HappyNumber h = new HappyNumber();
		System.out.println(h.isHappy(2));
		System.out.println(h.isHappy(19));
	}

}
