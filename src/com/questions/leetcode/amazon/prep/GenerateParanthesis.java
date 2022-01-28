package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		helper(result, "", n, n);
		return result;
	}

	private void helper(List<String> answer, String brackets, int open, int close) {
		if (open == 0 && close == 0) {
			answer.add(brackets);
		} else {
			if (open < close) {
				if (open > 0) {
					helper(answer, brackets + "(", open - 1, close);
					helper(answer, brackets + ")", open, close - 1);
				} else {

					helper(answer, brackets + ")", open, close - 1);
				}
			} else {
				helper(answer, brackets + "(", open - 1, close);
			}
		}
	}

	public static void main(String[] args) {
		GenerateParanthesis gp = new GenerateParanthesis();
		System.out.println(gp.generateParenthesis(3));
	}

}
