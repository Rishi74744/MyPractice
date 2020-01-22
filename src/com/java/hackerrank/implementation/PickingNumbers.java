package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PickingNumbers {

	static int pickingNumbers(int[] a) {
		int max = 1;
		Arrays.sort(a);
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> ll = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {

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

/**
 * 
 * 
 * for (int i = 0; i < a.length; i++) { int currCount = 1; for (int j = 0; j <
 * a.length; j++) { if (i != j && (i != a.length - 1)) { if (Math.abs(a[i] - a[i
 * + 1]) <= 1) { currCount++; if (currCount > max) { max = currCount; } } else {
 * currCount = 1; } } } }
 */
