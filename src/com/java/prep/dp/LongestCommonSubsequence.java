package com.java.prep.dp;

import java.util.Arrays;

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text1 = "abcde", text2 = "ace" Output: 3
 * 
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * Example 2:
 * 
 * Input: text1 = "abc", text2 = "abc" Output: 3
 * 
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * Example 3:
 * 
 * Input: text1 = "abc", text2 = "def" Output: 0
 * 
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * "mhunuzqrkzsnidwbun" "szulspmhwpazoxijwbq" Constraints:
 * 
 * 1 <= text1.length, text2.length <= 1000
 * 
 * text1 and text2 consist of only lowercase English characters.
 * 
 *
 */
public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(dp[i], -1);
		}
		return findLCS(m - 1, n - 1, text1.toCharArray(), text2.toCharArray(), dp);
	}

	/**
	 * Using Recursion
	 * 
	 * With DP ---------------
	 * 
	 * Complexity - O(m*n) - (m + 1) * (n + 1) distinct function calls.
	 * 
	 * Space - O(m*n) - Stack -> (m + n) levels + Array -> m*n
	 * 
	 * Without DP -------------
	 * 
	 * Complexity - O(2^m * 2^n)
	 * 
	 * Space - O(m + n) - Stack -> (m + n) levels
	 */
	public int findLCS(int m, int n, char[] text1, char[] text2, int[][] dp) {
		if (m < 0 || n < 0) {
			return 0;
		} else if (text1[m] == text2[n]) {
			if (dp[m][n] == -1) {
				dp[m][n] = 1 + findLCS(m - 1, n - 1, text1, text2, dp);
			}
			return dp[m][n];
		} else {
			int left = m > 0 && dp[m - 1][n] != -1 ? dp[m - 1][n] : findLCS(m - 1, n, text1, text2, dp);
			int right = n > 0 && dp[m][n - 1] != -1 ? dp[m][n - 1] : findLCS(m, n - 1, text1, text2, dp);
			dp[m][n] = Math.max(left, right);
			return dp[m][n];
		}
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		System.out.println(lcs.longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"));
	}

}
