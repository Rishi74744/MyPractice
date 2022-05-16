package com.java.prep.dp;

/**
 * Given an input string s and a pattern p, implement regular expression
 * matching with support for '.' and '*' where:
 * 
 * '.' Matches any single character.​​​​
 * 
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aa", p = "a" Output: false
 * 
 * Explanation: "a" does not match the entire string "aa".
 * 
 * Example 2:
 * 
 * Input: s = "aa", p = "a*" Output: true
 * 
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore,
 * by repeating 'a' once, it becomes "aa".
 * 
 * Example 3:
 * 
 * Input: s = "ab", p = ".*" Output: true
 * 
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 20
 * 
 * 1 <= p.length <= 30
 * 
 * s contains only lowercase English letters.
 * 
 * p contains only lowercase English letters, '.', and '*'.
 * 
 * It is guaranteed for each appearance of the character '*', there will be a
 * previous valid character to match.
 *
 */
public class RegularExpressionMatching {

	/**
	 * Complexity - O(n), Space - O(1)
	 */
	public boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[n][m] = true;
		for (int i = n; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				boolean thisCharMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
				if (j + 1 < m && p.charAt(j + 1) == '*') {
					dp[i][j] = dp[i][j + 2] || thisCharMatch && dp[i + 1][j];
				} else {
					dp[i][j] = thisCharMatch && dp[i + 1][j + 1];
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		RegularExpressionMatching w = new RegularExpressionMatching();
		System.out.println(w.isMatch("aab", "c*a*b"));
	}

}
