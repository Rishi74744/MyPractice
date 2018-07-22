package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class DrawingBook {

	/*
	 * Complete the pageCount function below.
	 */
	static int pageCount(int n, int p) {
		int back = n - p;
		if (p <= back) {
			return p / 2;
		} else {
			if (n % 2 == 0) {
				return (back + 1) / 2;
			} else {
				return (back - 1) / 2;
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int p = scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int result = pageCount(n, p);
		System.out.println(result);

		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}

}
