package com.java.concepts.ctci.chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CheckPermutation {

	public static boolean checkPermutation(String mainString, String permutationString) {
		Map<Character, Integer> mainStringCount = new HashMap<>();
		Map<Character, Integer> permutationStringCount = new HashMap<>();
		for (int i = 0; i < mainString.length(); i++) {
			char characterInString = mainString.charAt(i);
			if (mainStringCount.containsKey(characterInString)) {
				mainStringCount.put(characterInString, mainStringCount.get(characterInString) + 1);
			} else {
				mainStringCount.put(characterInString, 1);
			}
		}
		for (int i = 0; i < permutationString.length(); i++) {
			char characterInString = permutationString.charAt(i);
			if (permutationStringCount.containsKey(characterInString)) {
				permutationStringCount.put(characterInString, permutationStringCount.get(characterInString) + 1);
			} else {
				permutationStringCount.put(characterInString, 1);
			}
		}
		for (Entry<Character, Integer> mapEntries : permutationStringCount.entrySet()) {
			if (!mainStringCount.containsKey(mapEntries.getKey())
					|| mainStringCount.get(mapEntries.getKey()) < mapEntries.getValue()) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkPermutation("aabcbc", "abbc"));
	}

}
