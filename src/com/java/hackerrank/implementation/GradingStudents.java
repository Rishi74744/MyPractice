package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class GradingStudents {
	/*
	 * Complete the gradingStudents function below.
	 */
	static int[] gradingStudents(int[] grades) {
		int[] finalGrades = new int[grades.length];
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < 38) {
				finalGrades[i] = grades[i];
			} else {
				int r = grades[i] / 5;
				if (r == 0) {
					finalGrades[i] = grades[i];
				} else {
					int j = (r * 5) + 5;
					if ((j - grades[i]) >= 3) {
						finalGrades[i] = grades[i];
					} else {
						finalGrades[i] = j;
					}
				}
			}
		}
		return finalGrades;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bw = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(scan.nextLine().trim());

		int[] grades = new int[n];

		for (int gradesItr = 0; gradesItr < n; gradesItr++) {
			int gradesItem = Integer.parseInt(scan.nextLine().trim());
			grades[gradesItr] = gradesItem;
		}

		int[] result = gradingStudents(grades);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			// bw.write(String.valueOf(result[resultItr]));
			System.out.println(result[resultItr]);

			if (resultItr != result.length - 1) {
				// bw.write("\n");
			}
		}

		// bw.newLine();

		// bw.close();
	}
}
