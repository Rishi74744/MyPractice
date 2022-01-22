package com.questions.leetcode.amazon.prep;

import java.util.Stack;

public class ValidParatheses {

	public static boolean isValid(String s) {
		Stack<Character> parantheses = new Stack<>();
		for (char c : s.toCharArray()) {
			if (parantheses.isEmpty()) {
				parantheses.add(c);
			} else {
				char peek = parantheses.peek();
				if ((peek == '(' && c == ')') || (peek == '[' && c == ']') || (peek == '{' && c == '}')) {
					parantheses.pop();
				} else {
					parantheses.push(c);
				}
			}
		}
		return parantheses.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("((]"));
		System.out.println(isValid("(())[]"));
		System.out.println(isValid("({[]})"));
		System.out.println(isValid("((]"));
		System.out.println(isValid("((]"));
		System.out.println(isValid("(("));
	}

}
