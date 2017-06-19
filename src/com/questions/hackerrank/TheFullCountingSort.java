package com.questions.hackerrank;

import java.util.Scanner;

public class TheFullCountingSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = Integer.parseInt(scanner.nextLine());
		StringBuffer[] helper = new StringBuffer[100];
		for (int i = 0; i < 100; i++) {
			helper[i] = new StringBuffer();
		}
		for (int i = 0; i < total; i++) {
			String input = scanner.nextLine();
			String[] s1 = input.split(" ");
			int pos = Integer.parseInt(s1[0]);
			String s;
			if (i < total / 2) {
				s = "- ";
			} else {
				s = s1[1] + " ";
			}
			helper[pos] = helper[pos].append(s);
		}

		for (int i = 0; i < 100; i++) {
			System.out.print(helper[i]);
		}
	}

}
