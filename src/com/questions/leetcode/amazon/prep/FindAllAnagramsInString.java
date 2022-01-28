package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		Map<Character, Integer> anagramMap = new HashMap<>();
		for (char c : p.toCharArray()) {
			int count = 1;
			if (anagramMap.containsKey(c)) {
				count = anagramMap.get(c) + 1;
			}
			anagramMap.put(c, count);
		}
		int start = 0;
		while (start != s.length()) {
//			if(st)
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
