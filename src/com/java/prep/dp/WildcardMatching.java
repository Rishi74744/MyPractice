package com.java.prep.dp;

/**
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 * 
 * '?' Matches any single character.
 * 
 * '*' Matches any sequence of characters (including the empty sequence).
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
 * Input: s = "aa", p = "*" Output: true
 * 
 * Explanation: '*' matches any sequence.
 * 
 * Example 3:
 * 
 * Input: s = "cb", p = "?a" Output: false
 * 
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not
 * match 'b'.
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length, p.length <= 2000
 * 
 * s contains only lowercase English letters.
 * 
 * p contains only lowercase English letters, '?' or '*'. *
 */
public class WildcardMatching {

	/**
	 * Complexity - O(n), Space - O(1)
	 */
	public boolean isMatch(String s, String p) {
		int sPointer = 0;
		int pPointer = 0;
		int pointerWillCompareWithStarNext = -1;
		int starIndex = -1;
		while (sPointer < s.length()) {
			System.out.println("P Pointer : " + pPointer + " S Pointer : " + sPointer + " Pointer with Next Star : "
					+ pointerWillCompareWithStarNext + " Start Index: " + starIndex);
			if (sPointer < s.length() && pPointer < p.length()
					&& (s.charAt(sPointer) == p.charAt(pPointer) || p.charAt(pPointer) == '?')) {
				sPointer++;
				pPointer++;
			} else if (sPointer < s.length() && pPointer < p.length() && p.charAt(pPointer) == '*') {
				pointerWillCompareWithStarNext = sPointer;
				starIndex = pPointer;
				pPointer++;
			} else if (starIndex != -1) {
				sPointer = pointerWillCompareWithStarNext + 1;
				pPointer = starIndex + 1;
				pointerWillCompareWithStarNext++;
			} else {
				return false;
			}
		}
		while (pPointer < p.length() && p.charAt(pPointer) == '*') {
			pPointer++;
		}
		return pPointer == p.length();
	}

	public static void main(String[] args) {
		WildcardMatching w = new WildcardMatching();
		System.out.println(w.isMatch("cdrb", "c*be"));
	}

}
