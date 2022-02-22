package com.questions.leetcode.amazon.prep;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		if (s.equals(t)) {
			return s;
		}
		int count = 0;
		int currentStart = 0;
		int start = -1;
		int end = -1;
		int min = Integer.MAX_VALUE;
		Map<Character, Integer> tMap = new HashMap<>();
		Map<Character, Integer> countMap = new HashMap<>();
		for (char ch : t.toCharArray()) {
			tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (tMap.containsKey(c)) {
				countMap.put(c, countMap.getOrDefault(c, 0) + 1);
				if (countMap.get(c).equals(tMap.get(c))) {
					count++;
				}
				while (count == tMap.size()) {
					int currLen = i - currentStart;
					if (min > currLen) {
						min = currLen;
						start = currentStart;
						end = i;
					}
					c = s.charAt(currentStart++);
					if (countMap.containsKey(c)) {
						countMap.put(c, countMap.get(c) - 1);
						if (countMap.get(c) < tMap.get(c))
							count--;
					}
				}
			}
		}
		return start == -1 ? "" : s.substring(start, end + 1);
	}

	public static void main(String[] args) {
		System.out.println(minWindow("a", "aa"));
	}

}
