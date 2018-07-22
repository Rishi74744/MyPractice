package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class TaumAndBday {

	static long taumBday(int b, int w, int bc, int wc, int z) {
		long bp = bc;
		long wp = wc;
		if (bp > (wc + z)) {
			bp = wc + z;
		}
		if (wp > (bc + z)) {
			wp = bc + z;
		}
		return ((b * bp) + (w * wp));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] bw = scanner.nextLine().split(" ");

			int b = Integer.parseInt(bw[0]);

			int w = Integer.parseInt(bw[1]);

			String[] bcWcz = scanner.nextLine().split(" ");

			int bc = Integer.parseInt(bcWcz[0]);

			int wc = Integer.parseInt(bcWcz[1]);

			int z = Integer.parseInt(bcWcz[2]);

			long result = taumBday(b, w, bc, wc, z);

			System.out.println(result);

			/*
			 * bufferedWriter.write(String.valueOf(result));
			 * bufferedWriter.newLine();
			 */
		}

		// bufferedWriter.close();

		scanner.close();
	}

}
