package com.java.concepts.crack.code.interview.questions.chapter8;

import java.util.Scanner;

public class RobotInAGrid {

	static int row;
	static int col;

	public static int findPath(int arr[][], int r, int c) {
		if (r == row - 1 && c == col - 1) {
			arr[r][c] = 2;
			return 0;
		}
		if (r > row - 1 || c > col - 1) {
			return -1;
		}
		if (arr[r][c] == 1) {
			return -1;
		} else {
			arr[r][c] = 2;
			int x = findPath(arr, r + 1, c);
			if (x == -1) {
				int y = findPath(arr, r, c + 1);
				if (y == -1) {
					return -1;
				}
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		row = scanner.nextInt();
		col = scanner.nextInt();
		int arr[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		findPath(arr, 0, 0);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 2) {
					System.out.println(i + " ," + j);
				}
			}
		}
		scanner.close();

	}

}
