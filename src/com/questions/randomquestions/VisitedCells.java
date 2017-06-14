package com.questions.randomquestions;

import java.util.Scanner;

public class VisitedCells {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int visited[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; i < m; i++) {
				visited[i][j] = 0;
			}
		}
		int rot = 0;
		int i = 0;
		int j = 0;
		while (rot != 4) {
			visited[i][j] = 1;
			if (i <= n && (j + 1) <= m && visited[i][j + 1] == 0) {
				visited[i][j + 1] = 1;
				j++;
			} else {
				rot++;
			}
		}
	}

	public static void checkAfterRotations(int i, int j, int[][] visited) {

	}

	public static boolean checkForVisitation(int i, int j, int[][] visited) {
		return true;
	}

}
