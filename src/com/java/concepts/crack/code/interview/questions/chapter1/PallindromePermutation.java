package com.java.concepts.crack.code.interview.questions.chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PallindromePermutation {

	static Map<String, Integer> calculateAlphabetCount(String inputString) {
		Map<String, Integer> alphabetCount = new HashMap<>();
		for (int i = 0; i < inputString.length(); i++) {
			int alphabetCountValue = 1;
			String key = Character.toString(inputString.charAt(i));
			if (alphabetCount.containsKey(key)) {
				alphabetCountValue = alphabetCount.get(key) + 1;
			}
			alphabetCount.put(key, alphabetCountValue);
		}
		return alphabetCount;
	}

	static void printPallindromePermutation(String inputString, Map<String, Integer> alphabetCount) {
		char[] pallindrome = new char[inputString.length()];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		Map<String, Integer> alphabetCount = calculateAlphabetCount(inputString);
		int oddAlphabetCount = 0;
		for (Entry<String, Integer> entry : alphabetCount.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				oddAlphabetCount++;
			}
		}
		if (oddAlphabetCount > 1) {
			System.out.println("No Permutations");
		} else {

		}
		scanner.close();
	}

}
