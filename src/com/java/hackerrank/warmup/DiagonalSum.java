package com.java.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DiagonalSum {

	// Complete the diagonalDifference function below.
	static int diagonalDifference(int[][] a) {
		int primary = 0, secondary = 0;
		for (int i = 0, j = a.length - 1; i < a.length; i++, j--) {
			primary += a[i][i];
			secondary += a[i][j];
		}
		return Math.abs(primary - secondary);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[][] a = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] aRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < n; j++) {
				int aItem = Integer.parseInt(aRowItems[j]);
				a[i][j] = aItem;
			}
		}

		int result = diagonalDifference(a);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
