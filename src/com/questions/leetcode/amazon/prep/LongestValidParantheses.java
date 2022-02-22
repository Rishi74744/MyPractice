package com.questions.leetcode.amazon.prep;

import java.util.Stack;

public class LongestValidParantheses {

	public static int longestValidParentheses(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (st.isEmpty()) {
				st.push(s.charAt(i));
			} else if (st.peek() == '(' && s.charAt(i) == ')') {
				st.pop();
			} else {
				st.push(s.charAt(i));
			}
		}
		return s.length() - st.size();
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(()"));
	}

}
