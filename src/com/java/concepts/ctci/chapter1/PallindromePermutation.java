package com.java.concepts.ctci.chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PallindromePermutation {

	public static boolean checkIfPallindromePermutationExists(String input) {
		input = input.replaceAll(" ", "").toLowerCase();
		Map<Character, Integer> alphabetCount = calculateAlphabetCount(input);
		return calculateAlphabetsWithOddCount(alphabetCount) <= 1;
	}

	private static int calculateAlphabetsWithOddCount(Map<Character, Integer> alphabetCount) {
		int totalOddAlphabets = 0;
		for (Integer count : alphabetCount.values()) {
			if (count % 2 != 0) {
				totalOddAlphabets++;
			}
		}
		return totalOddAlphabets;
	}

	private static Map<Character, Integer> calculateAlphabetCount(String input) {
		Map<Character, Integer> alphabetCount = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			int count = 1;
			char currentAlphabet = input.charAt(i);
			if (alphabetCount.containsKey(currentAlphabet)) {
				count = alphabetCount.get(currentAlphabet) + 1;
			}
			alphabetCount.put(currentAlphabet, count);
		}
		return alphabetCount;
	}

	public static void main(String[] args) {
		System.out.println(checkIfPallindromePermutationExists("Tact ttcllpua"));
	}

}
