package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class LisasWorkbook {

	static int workbook(int n, int k, int[] arr) {
		int result = 0;
		int currentPage = 0;
		int previousPage = 1;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Chapter Number " + (i + 1));
			int totalProblems = arr[i];
			int totalpages = (totalProblems / k);
			if (totalProblems % k == 0) {
				currentPage += totalpages;
			} else {
				currentPage += (totalpages + 1);
			}
			for (int j = 1, count = 1; j <= totalProblems; j++, count++) {
				System.out.print("Problem No. " + j + " is on page : " + previousPage);
				if (j == previousPage) {
					System.out.print(" ---- Special Problem ---- ");
					result++;
				}
				if (count == k) {
					count = 1;
					previousPage++;
				}
				System.out.println();
			}
			previousPage = currentPage + 1;
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = workbook(n, k, arr);

		System.out.println(result);
		scanner.close();
	}

	/**
	 * 95 3 -> 9 1 1 81 16 1 100 89 100 100 100 2 100 3 100 3 100 100 100 100 100
	 * 100 100 100 100 100 100 100 100 100 1 100 100 100 100 100 100 100 100 100 100
	 * 100 100 100 100 100 100 2 100 100 100 1 100 100 100 100 100 100 100 1 100 100
	 * 100 100 100 100 100 100 100 100 100 100 2 100 100 3 100 100 100 100 3 100 100
	 * 100 100 100 100 100 100 100 100 100 100 100 100
	 */

}
