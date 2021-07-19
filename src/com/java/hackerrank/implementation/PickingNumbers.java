package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PickingNumbers {

	static int pickingNumbers(List<Integer> a) {
		int max = 0;
		int count[] = new int[101];
		for (int i = 0; i < a.size(); i++) {
			int number = a.get(i);
			int tot = count[number] + 1;
			count[number] = tot;
		}
		for (int i = 0; i < count.length - 1; i++) {
			int sum = count[i] + count[i + 1];
			if (sum > max) {
				max = sum;
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

		List<Integer> a = new ArrayList<>();

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a.add(aItem);
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
