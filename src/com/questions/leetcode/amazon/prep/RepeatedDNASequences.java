package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

	public static List<String> findRepeatedDnaSequences(String s) {
		Map<String, Integer> dnaCount = new HashMap<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String dna = s.substring(i, i + 10);
			dnaCount.put(dna, dnaCount.getOrDefault(dna, 0) + 1);
		}
		List<String> result = new ArrayList<>();
		for (Map.Entry<String, Integer> e : dnaCount.entrySet()) {
			if (e.getValue() >= 2) {
				result.add(e.getKey());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("A"));
	}

}
