package com.java.concepts.crack.code.interview.questions.chapter1;

import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		char last = inputString.charAt(0);
		StringBuilder finalString = new StringBuilder();
		int i = 1;
		int count = 1;
		while (i != inputString.length()) {
			if (inputString.charAt(i) == last) {
				count++;
			} else {
				finalString.append(Character.toString(last) + count);
				last = inputString.charAt(i);
				count = 1;
			}
			i++;
		}
		finalString.append(Character.toString(last) + count);
		if (finalString.toString().length() > inputString.length()) {
			System.out.println(inputString);
		} else {
			System.out.println(finalString.toString());
		}
		scanner.close();
	}

}
