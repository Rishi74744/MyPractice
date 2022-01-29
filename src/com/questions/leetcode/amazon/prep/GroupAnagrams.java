package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] sArr) {
		Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();
		for (int i = 0; i < sArr.length; i++) {
			Map<Character, Integer> stringCharCount = new HashMap<>();
			for (char ch : sArr[i].toCharArray()) {
				stringCharCount.put(ch, stringCharCount.getOrDefault(ch, 0) + 1);
			}
			anagrams.computeIfAbsent(stringCharCount, k -> new ArrayList<>()).add(sArr[i]);
		}
		return new ArrayList<>(anagrams.values());
	}
}
