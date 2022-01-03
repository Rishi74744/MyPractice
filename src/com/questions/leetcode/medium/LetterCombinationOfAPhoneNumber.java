package com.questions.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {

	public static List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<>();
		}
		Map<String, List<String>> keyMap = new HashMap<>();
		keyMap.put("2", Arrays.asList("a", "b", "c"));
		keyMap.put("3", Arrays.asList("d", "e", "f"));
		keyMap.put("4", Arrays.asList("g", "h", "i"));
		keyMap.put("5", Arrays.asList("j", "k", "l"));
		keyMap.put("6", Arrays.asList("m", "n", "o"));
		keyMap.put("7", Arrays.asList("p", "q", "r", "s"));
		keyMap.put("8", Arrays.asList("t", "u", "v"));
		keyMap.put("9", Arrays.asList("w", "x", "y", "z"));
		List<String> possibleCombinations = keyMap.get(digits.charAt(0) + "");
		for (int i = 1; i < digits.length(); i++) {
			List<String> nextPossibleCombinations = keyMap.get(digits.charAt(i) + "");
			List<String> intermediatePossibilies = new ArrayList<>();
			for (String combination : possibleCombinations) {
				for (String nextCombination : nextPossibleCombinations) {
					intermediatePossibilies.add(combination + nextCombination);
				}
			}
			possibleCombinations = intermediatePossibilies;
		}
		return possibleCombinations;
	}

	public static List<String> letterCombinationsWithRecursion(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<>();
		}
		Map<String, List<String>> keyMap = new HashMap<>();
		keyMap.put("2", Arrays.asList("a", "b", "c"));
		keyMap.put("3", Arrays.asList("d", "e", "f"));
		keyMap.put("4", Arrays.asList("g", "h", "i"));
		keyMap.put("5", Arrays.asList("j", "k", "l"));
		keyMap.put("6", Arrays.asList("m", "n", "o"));
		keyMap.put("7", Arrays.asList("p", "q", "r", "s"));
		keyMap.put("8", Arrays.asList("t", "u", "v"));
		keyMap.put("9", Arrays.asList("w", "x", "y", "z"));
		int mid = digits.length() / 2;
		List<String> combinations = new ArrayList<>();
		combine(mid, digits, combinations, keyMap);
		return combinations;
	}

	public static void combine(int level, String digits, List<String> possibilies, Map<String, List<String>> charMap) {
		System.out.println("At Level : " + level + " With Digits : " + digits + " And Possibilities : " + possibilies);
		List<String> combination = new ArrayList<>();
		if (level < 0 || level > digits.length() - 1) {
			return;
		}
		List<String> currentPossibilities = charMap.get(digits.charAt(level) + "");
		if (possibilies.isEmpty()) {
			combination = currentPossibilities;
		}
		for (String left : currentPossibilities) {
			for (String right : possibilies) {
				combination.add(left + right);
			}
		}
		if (!digits.substring(level + 1, digits.length()).isEmpty()) {
			combine(level - 1, digits.substring(0, level), combination, charMap);
		}
		if (!digits.substring(0, level).isEmpty()) {
			combine(level + 1, digits.substring(level + 1, digits.length()), combination, charMap);
		}
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("4679"));
		System.out.println(letterCombinationsWithRecursion("4679"));
	}

}
