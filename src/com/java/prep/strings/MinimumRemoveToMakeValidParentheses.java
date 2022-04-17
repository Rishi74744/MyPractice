package com.java.prep.strings;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
 * positions ) so that the resulting parentheses string is valid and return any
 * valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or
 * 
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * 
 * It can be written as (A), where A is a valid string.
 * 
 * Example 1:
 * 
 * Input: s = "lee(t(c)o)de)" Output: "lee(t(c)o)de"
 * 
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * 
 * Example 2:
 * 
 * Input: s = "a)b(c)d" Output: "ab(c)d"
 * 
 * Example 3:
 * 
 * Input: s = "))((" Output: ""
 * 
 * Explanation: An empty string is also valid.
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 10^5
 * 
 * s[i] is either'(' , ')', or lowercase English letter.
 */
public class MinimumRemoveToMakeValidParentheses {

	/**
	 * Complexity - O(n), Space - O(n)
	 */
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> index = new Stack<>();
		char[] valid = s.toCharArray();
		for (int i = 0; i < valid.length; i++) {
			if (valid[i] == '(' || valid[i] == ')') {
				if (index.empty()) {
					index.add(i);
				} else if (valid[index.peek()] == '(' && valid[i] == ')') {
					index.pop();
				} else {
					index.add(i);
				}
			}
		}
		while (!index.empty()) {
			valid[index.pop()] = ' ';
		}
		return new String(valid).replaceAll(" ", "");
	}

	public static void main(String[] args) {
		MinimumRemoveToMakeValidParentheses m = new MinimumRemoveToMakeValidParentheses();
		System.out.println(m.minRemoveToMakeValid("lee(t(c)o)de)"));
	}

}
