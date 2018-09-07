package com.java.concepts.crack.code.interview.questions.chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StringPermutation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string1 = scanner.nextLine();
		String string2 = scanner.nextLine();
		boolean isPermutation = false;
		if (string1.length() < string2.length()) {
			Map<String, Integer> map1 = calculateCharCount(string1);
			for (int i = 0; i < string2.length(); i++) {
				Map<String, Integer> map2 = calculateCharCount(string1.substring(i, string2.length()));
				isPermutation = checkIfCharCountIsSame(map1, map2);
				if (isPermutation) {
					break;
				}
			}
		} else if (string1.length() > string2.length()) {
			Map<String, Integer> map1 = calculateCharCount(string2);
			for (int i = 0; i < string1.length(); i++) {
				Map<String, Integer> map2 = calculateCharCount(string2.substring(i, string2.length()));
				isPermutation = checkIfCharCountIsSame(map1, map2);
				if (isPermutation) {
					break;
				}
			}
		} else {
			Map<String, Integer> map1 = calculateCharCount(string1);
			Map<String, Integer> map2 = calculateCharCount(string2);
			isPermutation = checkIfCharCountIsSame(map1, map2);
		}
		System.out.println(isPermutation);
		scanner.close();
	}

	static Map<String, Integer> calculateCharCount(String s) {
		Map<String, Integer> charCountMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			int value = 1;
			if (charCountMap.containsKey(Character.toString(s.charAt(i)))) {
				value = charCountMap.get(Character.toString(s.charAt(i)));
			}
			charCountMap.put(Character.toString(s.charAt(i)), value);
		}
		return charCountMap;
	}

	static boolean checkIfCharCountIsSame(Map<String, Integer> charCountMap1, Map<String, Integer> charCountMap2) {
		for (Entry<String, Integer> charCount1 : charCountMap1.entrySet()) {
			if (!charCountMap2.containsKey(charCount1.getKey())) {
				return false;
			} else {
				if (charCountMap2.get(charCount1.getKey()) != charCount1.getValue()) {
					return false;
				}
			}
		}
		return true;
	}

}