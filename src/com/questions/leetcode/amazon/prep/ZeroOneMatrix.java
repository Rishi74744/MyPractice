package com.questions.leetcode.amazon.prep;

public class ZeroOneMatrix {

	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int result[][] = new int[m][n];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				int c = 0;
				if (i == 0 && j == 0) {

					if (mat[i][j + 1] == 1) {
						c++;
					}
					if (mat[i + 1][j] == 1) {
						c++;
					}
				}

				result[i][j] = c;
			}
		}
		return result;
	}

}
