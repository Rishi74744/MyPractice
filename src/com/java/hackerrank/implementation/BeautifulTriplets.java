package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class BeautifulTriplets {

	static int beautifulTriplets(int d, int[] arr) {
		int result = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int count = 1;
			int k = i;
			for (int j = i - 1; j >= 0; j--) {
				int diff = arr[i] - arr[j];
				if (diff == d && count != 3) {
					System.out.println(arr[i] + ", " + arr[j]);
					i = j;
					count++;
				}
			}
			i = k;
			if (count == 3) {
				result++;
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = beautifulTriplets(d, arr);
		System.out.println("Result : " + result);
		scanner.close();
	}

}
