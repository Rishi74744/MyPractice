package com.java.concepts.crack.code.interview.questions.chapter1;

import java.util.Scanner;

public class OneWay {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String mainString = scanner.nextLine();
		String subString = scanner.nextLine();
		if (mainString.length() - subString.length() > 1) {
			System.out.println("NO");
		} else {
			int count = 0;
			int i = 0;
			int j = 0;
			while (i != mainString.length() && j != subString.length()) {
				if (mainString.charAt(i) == subString.charAt(j)) {
					i++;
					j++;
				} else {
					count++;
					i++;
					if (mainString.length() == subString.length()) {
						j++;
					}
				}
			}
			if (count > 1) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		scanner.close();
	}

}
