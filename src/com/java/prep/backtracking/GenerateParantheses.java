package com.java.prep.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * Example 1:
 * 
 * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * Example 2:
 * 
 * Input: n = 1 Output: ["()"]
 * 
 * Constraints:
 * 
 * 1 <= n <= 8
 */
public class GenerateParantheses {

	/**
	 * Complexity - O(4^n), Space - O(n)
	 */
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		helper(result, "", n, n);
		return result;
	}

	public void helper(List<String> result, String bracket, int open, int close) {
		if (open == 0 && close == 0) {
			result.add(bracket);
		} else {
			if (open < close) {
				if (open > 0) {
					helper(result, bracket + "(", open - 1, close);
					helper(result, bracket + ")", open, close - 1);
				} else {
					helper(result, bracket + ")", open, close - 1);
				}
			} else {
				helper(result, bracket + "(", open - 1, close);
			}
		}
	}

	public static void main(String[] args) {
		GenerateParantheses g = new GenerateParantheses();
		System.out.println(g.generateParenthesis(3));
	}

}
