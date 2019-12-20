package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class ServiceLane {

	static int[] serviceLane(int n, int[][] cases, int[] width) {
		int result[] = new int[cases.length];
		for (int i = 0; i < cases.length; i++) {
			int min = width[cases[i][0]];
			int currentCases[] = cases[i];
			for (int j = currentCases[0]; j <= currentCases[1]; j++) {
				if (width[j] < min) {
					min = width[j];
				}
			}
			result[i] = min;
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nt = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nt[0]);

		int t = Integer.parseInt(nt[1]);

		int[] width = new int[n];

		String[] widthItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int widthItem = Integer.parseInt(widthItems[i]);
			width[i] = widthItem;
		}

		int[][] cases = new int[t][2];

		for (int i = 0; i < t; i++) {
			String[] casesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int casesItem = Integer.parseInt(casesRowItems[j]);
				cases[i][j] = casesItem;
			}
		}

		int[] result = serviceLane(n, cases, width);

		for (int i = 0; i < result.length; i++) {
			System.out.print(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println("\n");
			}
		}

		scanner.close();
	}

}
