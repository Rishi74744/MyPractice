package com.java.prep.dp;

import java.util.Arrays;

/**
 * Given an integer n, return the number of strings of length n that consist
 * only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * 
 * A string s is lexicographically sorted if for all valid i, s[i] is the same
 * as or comes before s[i+1] in the alphabet.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: 5
 * 
 * Explanation: The 5 sorted strings that consist of vowels only are
 * ["a","e","i","o","u"].
 * 
 * Example 2:
 * 
 * Input: n = 2 Output: 15
 * 
 * Explanation: The 15 sorted strings that consist of vowels only are
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the
 * alphabet.
 * 
 * Example 3:
 * 
 * Input: n = 33 Output: 66045
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 50
 */
public class CountSortedVowelStrings {

	public int countVowelStrings(int n) {
		int dp[] = new int[5];
		Arrays.fill(dp, 1);
		int sum = 5;
		if (n == 1) {
			return sum;
		}

		for (int i = 2; i <= n + 1; i++) {
			dp[4] = dp[4];
			dp[3] += dp[4];
			dp[2] += dp[3];
			dp[1] += dp[2];
			dp[0] += dp[1];
		}
		return dp[0];
	}

	public int vowels(int n) {
		return ((n + 4) * (n + 3) * (n + 2) * (n + 1)) / 24;
	}

	public static void main(String[] args) {
		CountSortedVowelStrings c = new CountSortedVowelStrings();
		System.out.println(c.countVowelStrings(6));
		System.out.println(c.vowels(6));
	}

}
