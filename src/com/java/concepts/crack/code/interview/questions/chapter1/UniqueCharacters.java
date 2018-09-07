package com.java.concepts.crack.code.interview.questions.chapter1;

import java.util.Scanner;

public class UniqueCharacters {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String testString = scanner.nextLine();
		boolean isCharacterUnique = true;
		for (int i = 0; i < testString.length(); i++) {
			if (testString.substring(i + 1, testString.length()).contains(Character.toString(testString.charAt(i)))) {
				isCharacterUnique = false;
				break;
			}
		}
		if (isCharacterUnique) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		scanner.close();
	}

}
