package com.java.hackerrank.dynamic.programming;

import java.io.IOException;
import java.util.Scanner;

public class XorAndSum {

	/*
	 * Complete the xorAndSum function below.
	 */
	static int xorAndSum(String a, String b) {
		int num1 = Integer.parseInt(a, 2);
		int num2 = Integer.parseInt(b, 2);
		int sum = 0;
		for (int i = 0; i <= 314159; i++) {
			sum = sum + (num1 ^ (num2 >> i));
		}
		return sum;//(sum % ((10 ^ 9) + 7));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[				] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String a = scanner.nextLine();

		String b = scanner.nextLine();

		int result = xorAndSum(a, b);

		System.out.println(result);

		/*
		 * bufferedWriter.write(String.valueOf(result));
		 * bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */
	}

}