package com.questions.leetcode.amazon.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		List<Integer> p = Arrays.asList(-1, 0, 1, 2, 0);
		List<Integer> v = Arrays.asList(-2, 10, 10, -3, 10);
		System.out.println(bestSumAnyTreePath(p, v));
	}

	static int totalSum = Integer.MIN_VALUE;

	public static int bestSumAnyTreePath(List<Integer> parent, List<Integer> values) {
		totalSum = Integer.MIN_VALUE;
		Map<Integer, Set<Integer>> pathMap = new HashMap<>();
		int root = -1;
		for (int i = 0; i < parent.size(); i++) {
			pathMap.putIfAbsent(i, new HashSet<>());
		}
		for (int i = 0; i < parent.size(); i++) {
			if (parent.get(i) == -1) {
				root = i;
				continue;
			}
			pathMap.get(parent.get(i)).add(i);
		}
		search(pathMap, values, root);
		return totalSum;
	}

	public static int search(Map<Integer, Set<Integer>> pathMap, List<Integer> values, int currentIndex) {
		if (pathMap.get(currentIndex).size() == 0) {
			return values.get(currentIndex);
		}
		List<Integer> l = new ArrayList<>();
		for (int node : pathMap.get(currentIndex)) {
			int value = values.get(currentIndex);
			int nextValue = search(pathMap, values, node);
			l.add(Math.max(value + nextValue, value));
		}
		for (int val : l) {
			totalSum = Math.max(totalSum, val);
		}
		return totalSum;
	}

}
