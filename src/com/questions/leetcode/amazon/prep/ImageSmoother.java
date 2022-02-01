package com.questions.leetcode.amazon.prep;

public class ImageSmoother {

	public static int[][] imageSmoother(int[][] img) {
		int m = img.length;
		int n = img[0].length;
		int res[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < img[0].length; j++) {
				int r = i - 1;
				int c = j - 1;
				int sum = 0;
				int count = 0;
				for (int l = r; l < r + 3; l++) {
					for (int p = c; p < c + 3; p++) {
						if (l < 0 || p < 0 || l >= m || p >= n) {
							continue;
						}
						sum += img[l][p];
						count++;
					}
				}
				res[i][j] = (int) Math.floor(sum / count);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int img[][] = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };
		int res[][] = imageSmoother(img);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < img[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

}
