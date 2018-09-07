package com.java.concepts.crack.code.interview.questions.chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class TripleSteps {

	private static int count(int n, int arr[]) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (arr[n] > -1) {
			return arr[n];
		} else {
			arr[n] = count(n - 1, arr) + count(n - 2, arr) + count(n - 3, arr);
			return arr[n];
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n + 1];
		Arrays.fill(arr, -1);
		int result = count(n, arr);
		System.out.println(result);
		scanner.close();
	}

}
