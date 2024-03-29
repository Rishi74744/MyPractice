package com.java.concepts.crack.code.interview.questions.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static List<List<String>> sortByAnagrams(String[] sArr) {
		List<List<String>> main = new LinkedList<>();
		Map<String, List<String>> anagramMap = new HashMap<>();
		for (String s : sArr) {
			char c[] = s.replaceAll(" ", "").toCharArray();
			Arrays.sort(c);
			String sortedKey = new String(c);
			List<String> anagramList = null;
			if (anagramMap.containsKey(sortedKey)) {
				anagramList = anagramMap.get(sortedKey);
			} else {
				anagramList = new ArrayList<>();
			}
			anagramList.add(s);
			anagramMap.put(sortedKey, anagramList);
		}
		for (Map.Entry<String, List<String>> e : anagramMap.entrySet()) {
			main.add(e.getValue());
		}
		return main;
	}

	public static void main(String[] args) {
		String sArr[] = { "peek", "aba", "keep", "zyxz", "abaa", "lmn", "xyzz", "opqwew" };
		System.out.println(sortByAnagrams(sArr));

	}

}