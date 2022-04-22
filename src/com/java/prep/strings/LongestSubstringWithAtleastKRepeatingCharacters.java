package com.java.prep.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an integer k, return the length of the longest substring
 * of s such that the frequency of each character in this substring is greater
 * than or equal to k.
 * 
 * Example 1:
 * 
 * Input: s = "aaabb", k = 3 Output: 3
 * 
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 * 
 * Example 2:
 * 
 * Input: s = "ababbc", k = 2 Output: 5
 * 
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and
 * 'b' is repeated 3 times.
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 10^4
 * 
 * s consists of only lowercase English letters.
 * 
 * 1 <= k <= 10^5
 */
public class LongestSubstringWithAtleastKRepeatingCharacters {

	public int longestSubstring(String s, int k) {
		if (k == 1) {
			return s.length();
		}
		Map<Character, Integer> m = new HashMap<>();
		int max = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {

		}
		return 0;
	}

}
