package com.java.hackerrank.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TwoDArrayDS {

	static int findMaxHourGlass(int arr[][]) {
		int quadRow = 0;
		List<Integer> hourGlassSums = new ArrayList<>();
		while (quadRow != 4) {
			int quadCol = 0;
			while (quadCol != 4) {
				int sum = 0;
				for (int i = quadRow; i < quadRow + 3; i++) {
					for (int j = quadCol; j < quadCol + 3; j++) {
						if ((i - quadRow == j - quadCol) || (i != quadRow + 1 && j != quadCol)
								|| (i != quadRow + 1 && j != (quadCol + 2))) {
							//System.out.println("i : " + i + " j : " + j + " Element : " + arr[i][j]);
							sum += arr[i][j];
						}
					}
				}
				//System.out.println("Sum : " + sum + " Quad Row : " + quadRow + " Quad Col : " + quadCol);
				hourGlassSums.add(sum);
				quadCol++;
			}
			quadRow++;
		}
		return Collections.max(hourGlassSums);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		System.out.println(findMaxHourGlass(arr));
		scanner.close();
	}

}