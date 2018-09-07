package com.java.concepts.crack.code.interview.questions.chapter1;

import java.util.Scanner;

public class Urlify {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String url = scanner.nextLine();
		String result = urlify(url.toCharArray());
		System.out.println(result);
		scanner.close();
	}

	public static String urlify(char str[]) {
		int i = 0;
		int j = str.length - 1;
		StringBuilder result = new StringBuilder();
		while (str[i] == ' ' || str[j] == ' ') {
			if (str[i] == ' ')
				i++;
			if (str[j] == ' ')
				j--;
		}
		for (int k = i; k <= j; k++) {
			if (str[k] == ' ') {
				result.append("%20");
			} else {
				result.append(str[k]);
			}
		}
		return result.toString();
	}

}
// My   Idea  Is Greatest 
//My%20%20%20Idea%20%20Is%20Greatest
