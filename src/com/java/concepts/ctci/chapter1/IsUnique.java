package com.java.concepts.ctci.chapter1;

import java.util.HashMap;
import java.util.Map;

public class IsUnique {

	public static boolean checkIfUnique(String input) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			if (m.containsKey(input.charAt(i))) {
				return false;
			} else {
				m.put(input.charAt(i), 1);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkIfUnique("aborety"));
	}
	
}
