package com.questions.hackerrank;

import java.util.Scanner;

public class MigratoryBirds {

	static int migratoryBirds(int n, int[] ar) {
		int arr[] = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			arr[ar[i] - 1] += 1;
		}
		int max = arr[0];
		int id = 1;
		for (int i = 1; i < 5; i++) {
			if (max < arr[i]) {
				max = arr[i];
				id = i + 1;
			}
		}
		return id;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
		}
		int result = migratoryBirds(n, ar);
		System.out.println(result);
	}

}
