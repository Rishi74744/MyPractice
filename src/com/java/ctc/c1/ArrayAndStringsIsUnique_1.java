package com.java.ctc.c1;

import java.util.HashSet;
import java.util.Set;

public class ArrayAndStringsIsUnique_1 {

	public static boolean isUnique(String input) {
		Set<Character> inputSet = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			Character inputChar = input.charAt(i);
			if (inputSet.contains(inputChar)) {
				return false;
			}
			inputSet.add(inputChar);
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "abc _56378a";
		boolean isUnique = isUnique(input);
		System.out.println(isUnique);
	}

}
