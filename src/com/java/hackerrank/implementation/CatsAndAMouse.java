package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class CatsAndAMouse {
	// Complete the catAndMouse function below.
	static String catAndMouse(int x, int y, int z) {
		int p = Math.abs(x - z);
		int q = Math.abs(y - z);
		if (p == q) {
			return "Mouse C";
		} else if (p < q) {
			return "Cat A";
		} else {
			return "Cat B";
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] xyz = scanner.nextLine().split(" ");

			int x = Integer.parseInt(xyz[0]);

			int y = Integer.parseInt(xyz[1]);

			int z = Integer.parseInt(xyz[2]);

			String result = catAndMouse(x, y, z);
			System.out.println(result);
			// bufferedWriter.write(result);
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}
}
