package com.java.prep.strings;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: strs = ["flower","flow","flight"] Output: "fl"
 * 
 * Example 2:
 * 
 * Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no
 * common prefix among the input strings.
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 200
 * 
 * 0 <= strs[i].length <= 200
 * 
 * strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		String result = null;
		int j = 0;
		for (int i = 0; i < strs.length; i++) {
			if (i == 0) {
				result += strs[i].charAt(j);
			} else {
				if (!result.equals(strs[i].substring(0, j + 1))) {
					result = result.substring(0, result.length() - 1);
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String strs[] = { "flower", "flip", "fly" };
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(strs));
	}

}
