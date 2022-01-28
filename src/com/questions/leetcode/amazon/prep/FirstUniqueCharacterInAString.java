package com.questions.leetcode.amazon.prep;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueCharacterInAString {

	public static int firstUniqChar(String s) {
		Map<Character, Integer> m = new HashMap<>();
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = 1;
			if (m.containsKey(c)) {
				count = m.get(c) + 1;
			}
			if (count > 1) {
				q.remove(c);
			} else {
				q.add(c);
			}
			m.put(c, count);
		}
		int idx = -1;
		if (!q.isEmpty()) {
			char search = q.poll();
			for (int i = 0; i < s.length(); i++) {
				if (search == s.charAt(i)) {
					idx = i;
					break;
				}
			}
		}
		return idx;
	}

	public static int firstUniqChar1(String s) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = 1;
			if (m.containsKey(c)) {
				count = m.get(c) + 1;
			}
			m.put(c, count);
		}
		int idx = -1;
		for (int i = 0; i < s.length(); i++) {
			if (m.get(s.charAt(i)) == 1) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	public static int firstUniqChar2(String s) {
		for (char c : s.toCharArray()) {
			if (s.indexOf(c) == s.lastIndexOf(c)) {
				return s.indexOf(c);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar1("loveleetcode"));
	}

}
