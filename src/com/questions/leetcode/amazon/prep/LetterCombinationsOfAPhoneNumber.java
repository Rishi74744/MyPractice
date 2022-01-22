package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	public static List<String> letterCombinations(String digits) {
		String combinations[] = initialize();
		List<String> results = new ArrayList<>();
		if (digits == null || digits.isEmpty()) {
			return results;
		}
		solve(digits, 0, "", combinations, results);
		return results;
	}

	static void solve(String digits, int index, String combinationString, String[] combinations, List<String> results) {
		if (index == digits.length()) {
			results.add(combinationString);
			return;
		}
		for (Character c : combinations[Character.getNumericValue(digits.charAt(index)) - 2].toCharArray()) {
			String comb = combinationString + c;
			solve(digits, index + 1, comb, combinations, results);
		}
	}

	static String[] initialize() {
		String comb[] = new String[8];
		comb[0] = "abc";
		comb[1] = "def";
		comb[2] = "ghi";
		comb[3] = "jkl";
		comb[4] = "mno";
		comb[5] = "pqrs";
		comb[6] = "tuv";
		comb[7] = "wxyz";

		return comb;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("65"));
	}

}
