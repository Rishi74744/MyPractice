package com.java.prep.arrays;

/**
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: digits = [1,2,3] Output: [1,2,4]
 * 
 * Explanation: The array represents the integer 123. Incrementing by one gives
 * 123 + 1 = 124. Thus, the result should be [1,2,4].
 * 
 * Example 2:
 * 
 * Input: digits = [4,3,2,1] Output: [4,3,2,2]
 * 
 * Explanation: The array represents the integer 4321. Incrementing by one gives
 * 4321 + 1 = 4322. Thus, the result should be [4,3,2,2].
 * 
 * Example 3:
 * 
 * Input: digits = [9] Output: [1,0]
 * 
 * Explanation: The array represents the integer 9. Incrementing by one gives 9
 * + 1 = 10. Thus, the result should be [1,0].
 * 
 * 
 * Constraints:
 * 
 * 1 <= digits.length <= 100
 * 
 * 0 <= digits[i] <= 9
 * 
 * digits does not contain any leading 0's.
 * 
 *
 */

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int n = digits.length;
		digits[n - 1] += 1;
		int carry = digits[n - 1] >= 10 ? 1 : 0;
		digits[n - 1] %= 10;
		if (carry == 1) {
			for (int i = n - 2; i >= 0; i--) {
				digits[i] += carry;
				carry = digits[i] >= 10 ? 1 : 0;
				digits[i] %= 10;
				if (carry == 0) {
					break;
				}
			}
			if (carry == 1) {
				int arr[] = new int[digits.length + 1];
				arr[0] = carry;
				for (int i = 1; i < arr.length; i++) {
					arr[i] = digits[i - 1];
				}
				return arr;
			}
		}
		return digits;
	}

	/**
	 * Complexity - O(n) where n is number of digits. Space -> Best Case - O(1), Worst Case - O(n).
	 */
	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		int digits[] = { 9, 8, 9 };
		int result[] = p.plusOne(digits);
		for (int i : result) {
			System.out.print(i + " ");
		}

	}

}
