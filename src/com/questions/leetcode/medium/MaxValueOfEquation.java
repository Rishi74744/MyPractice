package com.questions.leetcode.medium;

public class MaxValueOfEquation {

	public static int findMaxValueOfEquation(int[][] points, int k) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= points.length - 2; i++) {
			int j = i + 1;
			int abs = Math.abs(points[i][0] - points[j][0]);
			if (abs <= k) {
				int equationValue = points[i][1] + points[j][1] + abs;
				if (equationValue >= max) {
					max = equationValue;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] points = { { -19, -12 }, { -13, -18 }, { -12, 18 }, { -11, -8 }, { -8, 2 }, { -7, 12 }, { -5, 16 },
				{ -3, 9 }, { 1, -7 }, { 5, -4 }, { 6, -20 }, { 10, 4 }, { 16, 4 }, { 19, -9 }, { 20, 19 } };
		int k = 6;
		System.out.println(findMaxValueOfEquation(points, k));
	}

}
