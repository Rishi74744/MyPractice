package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class PickingNumbers {

	// Complete the pickingNumbers function below.
	static int pickingNumbers(int[] a) {
		int max = 1;
		int currCount = 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				if (i != a.length - 1) {
					if (a[i] - a[i + 1] <= 1) {
						currCount++;
						if (currCount > max) {
							max = currCount;
						}
					} else {
						currCount = 1;
					}
				}
			}
		}
		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int result = pickingNumbers(a);
		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}

}
