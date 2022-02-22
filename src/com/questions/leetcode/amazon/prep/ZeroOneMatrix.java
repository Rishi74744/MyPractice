package com.questions.leetcode.amazon.prep;

public class ZeroOneMatrix {

	public static int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int result[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					result[i][j] = 0;
				} else {
					int a = Integer.MAX_VALUE;
					int b = Integer.MAX_VALUE;
					int c = Integer.MAX_VALUE;
					int d = Integer.MAX_VALUE;
					if (i - 1 >= 0) {
						if (mat[i - 1][j] == 0) {
							result[i][j] = 1;
							continue;
						} else {
							a = result[i - 1][j] + 1;
						}
					}
					if (i + 1 < m) {
						if (mat[i + 1][j] == 0) {
							result[i][j] = 1;
							continue;
						} else {
							b = result[i + 1][j] + 1;
						}
					}
					if (j - 1 >= 0) {
						if (mat[i][j - 1] == 0) {
							result[i][j] = 1;
							continue;
						} else {
							c = result[i][j - 1] + 1;
						}
					}
					if (j + 1 < m) {
						if (mat[i][j + 1] == 0) {
							result[i][j] = 1;
							continue;
						} else {
							d = result[i][j + 1] + 1;
						}
					}
					result[i][j] = Math.min(a, Math.min(b, Math.min(c, d)));
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int m[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int r[][] = updateMatrix(m);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(r[i][j] + " ");
			}
			System.out.println();
		}
	}

}
