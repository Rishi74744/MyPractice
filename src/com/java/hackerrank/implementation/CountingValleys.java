package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		String str[] = s.split("");
		String last = str[0];
		int count = 0;
		String b = "Base";
		for (int i = 1; i < n; i++) {
			System.out.println(count);
			if ("U".equals(str[i - 1])) {
				count++;
			} else if ("D".equals(str[i - 1])) {
				count--;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}

}
