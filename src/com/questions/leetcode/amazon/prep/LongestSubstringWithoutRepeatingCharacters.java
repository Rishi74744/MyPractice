package com.questions.leetcode.amazon.prep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		if (input.length() == 1) {
			return 1;
		}
		Map<Character, Integer> indexMap = new HashMap<>();
		int max = 1;
		int i = 0;
		int j = 1;
		indexMap.put(input.charAt(i), i);
		while (j < input.length()) {
			char inputChar = input.charAt(j);
			if (indexMap.containsKey(inputChar)) {
				int start = indexMap.get(inputChar) + 1;
				if (start > i) {
					i = start;
				}
			}
			if (max < (j - i + 1)) {
				max = j - i + 1;
			}
			indexMap.put(inputChar, j);
			j++;
		}
		return max;
	}

	public static int lengthOfLongestSubstring1(String s) {
		int count = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(Character.toString(s.charAt(i))) != true) {
				count++;
				map.put(Character.toString(s.charAt(i)), count);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring1("pwwkew"));
	}

}