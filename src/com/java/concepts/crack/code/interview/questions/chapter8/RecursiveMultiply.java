package com.java.concepts.crack.code.interview.questions.chapter8;

import java.util.Scanner;

public class RecursiveMultiply {

	private static int recursiveMultiply(int n, int m) {
		if (m == 1) {
			return n;
		} else {
			return n + recursiveMultiply(n, m - 1);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int result = recursiveMultiply(n, m);
		System.out.println(result);
		scanner.close();
	}

}