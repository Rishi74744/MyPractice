package com.questions.leetcode.amazon.prep;

import java.util.Stack;

public class BasicCalculator {

	public static int calculate(String s) {
		int result = 0;
		Stack<Character> exp = new Stack<>();
		for (char c : s.toCharArray()) {
			exp.add(c);
		}
		return result;
	}

}
