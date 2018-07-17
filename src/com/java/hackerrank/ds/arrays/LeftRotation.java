package com.java.hackerrank.ds.arrays;

import java.util.Scanner;

public class LeftRotation {

	static int[] rotate(int arr[], int r) {
		int n = arr.length;
		int rotArr[] = new int[n];
		int numOfRot = r % arr.length;
		for (int i = 0; i < n; i++) {
			int k = n - numOfRot + i;
			if (k == n) {
				rotArr[0] = arr[i];
			} else if (k < n) {
				rotArr[k] = arr[i];
			} else {
				rotArr[k - n] = arr[i];
			}
		}
		return rotArr;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}
		int r[] = rotate(a, d);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
		scanner.close();
	}
}
