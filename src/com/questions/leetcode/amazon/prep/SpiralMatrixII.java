package com.questions.leetcode.amazon.prep;

public class SpiralMatrixII {

	public static int[][] generateMatrix(int n) {
		int result[][] = new int[n][n];
		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 0;
		int colEnd = n - 1;
		int totalCount = 0;
		int i = 0;
		int j = 0;
		while (totalCount != (n * n)) {
			while (i <= rowEnd && j <= colEnd && totalCount != (n * n)) {
				totalCount++;
				result[i][j] = totalCount;
				j++;
			}
			if (i <= rowEnd && j > colEnd && totalCount != (n * n)) {
				rowStart++;
				j--;
				i++;
			}
			while (i <= rowEnd && j == colEnd && totalCount != (n * n)) {
				totalCount++;
				result[i][j] = totalCount;
				i++;
			}
			if (i > rowEnd && j == colEnd) {
				colEnd--;
				j--;
				i--;
			}
			while (i == rowEnd && j >= colStart && totalCount != (n * n)) {
				totalCount++;
				result[i][j] = totalCount;
				j--;
			}
			if (i == rowEnd && j < colStart) {
				rowEnd--;
				j++;
				i--;
			}
			while (i >= rowStart && j == colStart && totalCount != (n * n)) {
				totalCount++;
				result[i][j] = totalCount;
				i--;
			}
			if (i < rowStart && j <= colStart) {
				colStart++;
				i++;
				j++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 1;
		int result[][] = generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
