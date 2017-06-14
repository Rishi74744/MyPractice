package com.questions.hackerrank;

import java.util.Scanner;

public class GradingStudents {

	static int[] solve(int[] grades) {
		int result[] = new int[grades.length];
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 38) {
				if (grades[i] % 5 == 0) {
					result[i] = grades[i];
				} else {
					int j = grades[i] / 10;
					int k = grades[i] % 10;
					int mulOfFive = 0;
					if (k < 5) {
						mulOfFive = j * 10 + 5;
					} else {
						mulOfFive = j * 10 + 10;
					}
					if (mulOfFive - grades[i] < 3)
						result[i] = mulOfFive;
					else
						result[i] = grades[i];
				}
			} else {
				result[i] = grades[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i < n; grades_i++) {
			grades[grades_i] = in.nextInt();
		}
		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");

	}

}
