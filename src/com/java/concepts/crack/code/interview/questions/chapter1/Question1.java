package com.java.concepts.crack.code.interview.questions.chapter1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question1 {

	public static boolean uniqueCharacters(String str) {
		Set<Character> schr = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			if (schr.contains(str.charAt(i))) {
				return false;
			} else {
				schr.add(str.charAt(i));
			}
		}
		return true;
	}

	public static boolean uniqueCharactersWithoutDS(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println("Is all unique with another DS : " + uniqueCharacters(str));
		System.out.println("Is all unique without another DS : " + uniqueCharactersWithoutDS(str));

		scanner.close();
	}

}

/**
 * Question : 1 ---> Is Unique: Implement an algorithm to determine if a string
 * has all unique characters. What if you cannot use additional data structures?
 */
