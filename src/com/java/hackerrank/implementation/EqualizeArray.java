package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EqualizeArray {

	static int equalizeArray(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt() + 2;
		int countArr[] = new int[max];
		for (int i = 0; i < arr.length; i++) {
			int val = countArr[arr[i]] + 1;
			countArr[arr[i]] = val;
		}
		return arr.length - Arrays.stream(countArr).max().getAsInt();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = equalizeArray(arr);
		System.out.println(result);

		/*
		 * bufferedWriter.write(String.valueOf(result));
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */

		scanner.close();
	}

}
