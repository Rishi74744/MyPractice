package com.java.prep.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int m = matrix.length;
		int n = matrix[0].length;
		int rowStart = 0;
		int rowEnd = m - 1;
		int colStart = 0;
		int colEnd = n - 1;
		int totalCount = 0;
		int i = 0;
		int j = 0;
		while (totalCount != (m * n)) {
			while (i <= rowEnd && j <= colEnd && totalCount != (m * n)) {
				result.add(matrix[i][j]);
				totalCount++;
				j++;
			}
			if (i <= rowEnd && j > colEnd && totalCount != (m * n)) {
				rowStart++;
				j--;
				i++;
			}
			while (i <= rowEnd && j == colEnd && totalCount != (m * n)) {
				result.add(matrix[i][j]);
				totalCount++;
				i++;
			}
			if (i > rowEnd && j == colEnd) {
				colEnd--;
				j--;
				i--;
			}
			while (i == rowEnd && j >= colStart && totalCount != (m * n)) {
				result.add(matrix[i][j]);
				totalCount++;
				j--;
			}
			if (i == rowEnd && j < colStart) {
				rowEnd--;
				j++;
				i--;
			}
			while (i >= rowStart && j == colStart && totalCount != (m * n)) {
				result.add(matrix[i][j]);
				totalCount++;
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
		int matrix[][] = { { 7 }, { 9 }, { 6 } };
		System.out.println(spiralOrder(matrix));
	}

}
