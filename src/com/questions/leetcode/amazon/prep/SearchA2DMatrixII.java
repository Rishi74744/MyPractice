package com.questions.leetcode.amazon.prep;

public class SearchA2DMatrixII {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] < target) {
				if (i > 0) {
					i--;
				}
				j++;
			} else {
				if (j > 0) {
					j--;
				}
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(searchMatrix(matrix, 21));
	}

}
