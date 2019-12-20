package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class BiggerIsGreater {

	static boolean nextPermutation(int[] array) {
		// Find longest non-increasing suffix
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i])
			i--;
		// Now i is the head index of the suffix

		// Are we at the last permutation already?
		if (i <= 0)
			return false;

		// Let array[i - 1] be the pivot
		// Find rightmost element that exceeds the pivot
		int j = array.length - 1;
		while (array[j] <= array[i - 1])
			j--;
		// Now the value array[j] will become the new pivot
		// Assertion: j >= i

		// Swap the pivot with j
		int temp = array[i - 1];
		array[i - 1] = array[j];
		array[j] = temp;

		// Reverse the suffix
		j = array.length - 1;
		while (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}

		// Successfully computed the next permutation
		return true;
	}

	static String biggerIsGreater(String w) {
		StringBuilder result = new StringBuilder();
		char arr[] = w.toCharArray();
		int array[] = new int[arr.length];
		int i = 0;
		for (char c : arr) {
			array[i] = (int) c;
			i++;
		}
		if (nextPermutation(array)) {
			for (i = 0; i < array.length; i++) {
				result.append((char) array[i]);
			}
		} else {
			return "no answer";
		}
		return result.toString();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int T = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int TItr = 0; TItr < T; TItr++) {
			String w = scanner.nextLine();

			String result = biggerIsGreater(w);
			System.out.println(result);
		}
		scanner.close();
	}

}
