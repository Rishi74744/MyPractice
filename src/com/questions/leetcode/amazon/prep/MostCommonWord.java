package com.questions.leetcode.amazon.prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {

	public static String mostCommonWord(String paragraph, String[] banned) {
		paragraph = paragraph.replaceAll("[^a-zA-Z ]", " ");
		paragraph = paragraph.toLowerCase();
		Map<String, Integer> m = new HashMap<>();
		List<String> bannedList = Arrays.asList(banned);
		for (String s : paragraph.split(" ")) {
			if (!bannedList.contains(s)) {
				int count = 1;
				if (m.containsKey(s)) {
					count = m.get(s) + 1;
				}
				m.put(s, count);
			}
		}
		int max = 0;
		String maxString = null;
		for (String key : m.keySet()) {
			if (max < m.get(key)) {
				max = m.get(key);
				maxString = key;
			}
		}
		return maxString;
	}

	public static void main(String[] args) {
		String p = "a ,a,a,a,a, b,b,b,b,c,c, c";
		String banned[] = { "hit" };
		System.out.println(mostCommonWord(p, banned));
	}

}
