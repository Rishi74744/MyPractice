package com.java.hackerrank.warmup;

import java.util.Scanner;

public class StairCase {
	// Complete the staircase function below.
	static void staircase(int n) {
		for (int i = 0; i < n; i++) {
			int sp = n - i - 1;
			int st = i + 1;
			if (sp != 0) {
				for (int k = sp; k > 0; k--) {
					System.out.print(" ");
				}
			}
			if (st <= n) {
				for (int k = 0; k < st; k++) {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		staircase(n);
		scanner.close();
	}

}
