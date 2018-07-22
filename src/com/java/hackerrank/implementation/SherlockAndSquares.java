package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class SherlockAndSquares {

	// Complete the squares function below.
	static long squares(long a, long b) {
		long count = 0;
		boolean isFirst = false;
		for (long i = a; i <= b;) {
			double sqrti = Math.sqrt(i);
			if (sqrti % 1 == 0) {
				if (!isFirst) {
					isFirst = true;
				}
				i = i + (2 * (int) sqrti) + 1;
				count++;
			} else {
				i++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] ab = scanner.nextLine().split(" ");

			long a = Long.parseLong(ab[0]);

			long b = Long.parseLong(ab[1]);

			long result = squares(a, b);
			System.out.println(result);
			// bufferedWriter.write(String.valueOf(result));
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}

}