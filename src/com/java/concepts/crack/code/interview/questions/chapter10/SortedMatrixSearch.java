package com.java.concepts.crack.code.interview.questions.chapter10;

import java.util.Arrays;
import java.util.Scanner;

public class SortedMatrixSearch {

	public static int[] search(int a[][], int m, int n, int s) {
		int result[] = new int[2];
		int i = 0;
		int j = 0;
		int k = m - 1;
		int l = n - 1;
		Arrays.fill(result, -1);
		while (true) {
			if (i == n || j == m) {
				break;
			}
			if (a[i][k] == s) {
				result[0] = i;
				result[1] = k;
				break;
			}
			if (a[l][j] == s) {
				result[0] = l;
				result[1] = j;
				break;
			}
			if (i != n) {
				if (a[i][k] < s) {
					i++;
				} else {
					k--;
				}
			}
			if (j != m) {
				if (a[l][j] < s) {
					j++;
				} else {
					l--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = scanner.nextInt();
		System.out.println("Enter m : ");
		int m = scanner.nextInt();
		int arr[][] = new int[n][m];
		System.out.println("Enter array elements (Each row and column must be sorted) : ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		System.out.println("Enter element to search : ");
		int s = scanner.nextInt();
		int result[] = search(arr, m, n, s);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		scanner.close();
	}

}