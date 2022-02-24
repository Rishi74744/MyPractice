package com.java.prep.math;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-231, 231 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 123 Output: 321 Example 2:
 * 
 * Input: x = -123 Output: -321 Example 3:
 * 
 * Input: x = 120 Output: 21
 * 
 * 
 * Constraints:
 * 
 * -2^31 <= x <= 2^31 - 1
 * 
 *
 */
public class ReverseInteger {

	public int reverse(int x) {
		int reversedNum = 0;
		while (x != 0) {
			int r = x % 10;
			if (reversedNum > Integer.MAX_VALUE / 10 || reversedNum < Integer.MIN_VALUE / 10) {
				return 0;
			}
			reversedNum = reversedNum * 10 + r;
			x = x / 10;
		}
		return reversedNum;
	}

	/**
	 * Complexity - O(n) where n is length of integer. Space - O(1)
	 */

	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(-2140748100));
	}

}
