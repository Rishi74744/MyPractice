package com.questions.leetcode.easy;

import java.util.Stack;

public class ValidParanthesis {
	

	public static boolean isValid(String s) {
		Stack<String> stack = new Stack<>();
		boolean isValid = true;
		if(s.length() % 2 == 1) {
			return false;
		}
		int i = 0;
		while(i != s.length()) {
			String bracket = Character.toString(s.charAt(i));
			if(stack.size() == 0) {
				stack.push(bracket);
			} else {
				if(bracket.equals("(") || bracket.equals("{") || bracket.equals("[")) {
					stack.add(bracket);
				} else {
					String tos = stack.peek();
					if (!((tos.equals("(") && bracket.equals(")")) || (tos.equals("{") && bracket.equals("}")) || (tos.equals("[") && bracket.equals("]")))) {
						isValid = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			i++;
		}
		if(stack.size() > 0) {
			isValid = false;
		}
		
		return isValid;
	}

	public static void main(String[] args) {
		System.out.print(isValid("(("));
	}

}
