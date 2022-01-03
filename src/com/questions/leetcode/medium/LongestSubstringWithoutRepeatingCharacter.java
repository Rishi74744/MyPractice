package com.questions.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

	public static int getLongestSubstringLength(String input) {
		int max = 0;
		Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
		int i = 0;
		int j = 1;
		if (input == null || input.length() == 0) {
			return 0;
		}
		if (input.length() == 1) {
			return 1;
		}
		indexMap.put(input.charAt(i), i);
		while (j < input.length()) {
			char charAtJ = input.charAt(j);
			if (indexMap.containsKey(charAtJ)) {
				int newIndex = indexMap.get(charAtJ) + 1;
				if (newIndex >= i) {
					i = newIndex;
				}
			}
			indexMap.put(charAtJ, j);
			int currentMax = j - i + 1;
			if (max < currentMax) {
				max = currentMax;
			}
			j++;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(getLongestSubstringLength("bbbb"));
	}

}
