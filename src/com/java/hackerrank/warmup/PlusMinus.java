package com.java.hackerrank.warmup;

import java.util.Scanner;

public class PlusMinus {

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		int neg = 0, pos = 0, zero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				neg++;
			} else if (arr[i] == 0) {
				zero++;
			} else {
				pos++;
			}
		}
		double t = arr.length;
		double p = pos/t;
		double n = neg/t;
		double z = zero/t;
		System.out.println(p);
		System.out.println(n);
		System.out.println(z);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}

}
