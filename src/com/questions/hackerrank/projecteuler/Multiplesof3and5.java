package com.questions.hackerrank.projecteuler;

import java.util.Scanner;

public class Multiplesof3and5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			long numByT = (n - 1) / 3;
			long numByF = (n - 1) / 5;
			long numByB = (n - 1) / 15;
			long op = 3 * numByT * (numByT + 1) / 2 + 5 * numByF * (numByF + 1) / 2 - 15 * numByB * (numByB + 1) / 2;
			System.out.println(op);
		}
	}

}
