package com.questions.randomquestions;

public class FullPyramid {

	public static void main(String[] args) {
		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int space = 1; space <= (n - i); space++) {
				System.out.print("  ");
			}
			int k = 0;
			while (k != (2 * i - 1)) {
				System.out.print("* ");
				k++;
			}
			k = 0;
			System.out.println();
		}
	}

}
