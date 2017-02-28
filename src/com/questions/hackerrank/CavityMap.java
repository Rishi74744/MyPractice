package com.questions.hackerrank;

import java.util.Scanner;

public class CavityMap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			for (int j = n - 1; j >= 0; j--) {
				int r = num % 10;
				num = num / 10;
				arr[i][j] = r;
			}
		}
		int newArr[][] = new int[n][n];
		newArr = arr;
		if (n == 2) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
		for (int i = 1; i <= (n - 2); i++) {
			for (int j = 1; j <= (n - 2); j++) {
				int x = i - 1;
				int y = j - 1;
				if (checkIfCavity(arr, i, j)) {
					newArr[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (newArr[i][j] == -1) {
					System.out.print("X");
				} else {
					System.out.print(newArr[i][j]);
				}
			}
			System.out.println();
		}

	}

	private static boolean checkIfCavity(int arr[][], int i, int j) {
		if ((arr[i - 1][j] > arr[i][j])) {
			return false;
		}
		if ((arr[i][j - 1] > arr[i][j]) || (arr[i][j + 1] > arr[i][j])) {
			return false;
		}
		if ((arr[i][j - 1] > arr[i][j])) {
			return false;
		}
		return true;
	}

}
