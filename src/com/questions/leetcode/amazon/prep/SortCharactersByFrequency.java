package com.questions.leetcode.amazon.prep;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

	public static String frequencySort(String s) {
		Map<String, Integer> m = new HashMap<>();
		List<String> l = Arrays.asList(s.split(""));
		for (String c : l) {
			if (!m.containsKey(c)) {
				m.put(c, Collections.frequency(l, c));
			}
		}
		StringBuilder sorted = new StringBuilder();
		m.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(entry -> {
			for (int i = 1; i <= entry.getValue(); i++) {
				sorted.append(entry.getKey().toString());
			}
		});
		return sorted.toString();
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("cccaaa323222AAAbbd"));
	}

}
