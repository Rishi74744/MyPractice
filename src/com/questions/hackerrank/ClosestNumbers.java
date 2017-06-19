package com.questions.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		Arrays.sort(a);
		int min = Math.abs(a[0] - a[1]);
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < n - 1; i++) {
			int diff = Math.abs(a[i] - a[i + 1]);
			if (diff < min) {
				min = diff;
				str = new StringBuilder();
				str.append(a[i] + " " + a[i + 1] + " ");
			} else if (diff == min) {
				str.append(a[i] + " " + a[i + 1] + " ");
			}
		}
		System.out.println(str);
	}
}
