package com.questions.hackerrank;

import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			int m = sc.nextInt();
			int totalWrappers = 0;
			int candy = n / c;
			int total = 0;
			totalWrappers = candy;
			int noOfCandyFromWrappers = candy / m;
			while (totalWrappers >= m) {
				int leftWrappers = candy - noOfCandyFromWrappers * m;
				total = candy + noOfCandyFromWrappers;
				totalWrappers = totalWrappers - (noOfCandyFromWrappers * m) + leftWrappers;
			}
			System.out.println(total);
		}
	}

}
