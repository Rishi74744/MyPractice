package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {

	static int jumpingOnClouds(int[] c) {
		int steps = 0;
		for (int i = 0; i < c.length;) {
			if ((i + 2) < c.length && c[i + 2] == 0) {
				i = i + 2;
				steps++;
			} else if ((i + 1) < c.length && c[i + 1] == 0) {
				i = i + 1;
				steps++;
			} else {
				i++;
			}
		}
		return steps;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);
		System.out.println(result);

		/*
		 * bufferedWriter.write(String.valueOf(result));
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */

		scanner.close();
	}

}
