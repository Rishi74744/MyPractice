package com.java.hackerrank.implementation;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class ACMICPCTeam {

	// Complete the acmTeam function below.
	static int[] acmTeam(String[] topic) {
		int max = 0, count = 0;
		for (int i = 0; i < topic.length; i++) {
			for (int j = i + 1; j < topic.length; j++) {
				BigInteger b1 = new BigInteger(topic[i], 2);
				BigInteger b2 = new BigInteger(topic[j], 2);
				BigInteger c = b1.or(b2);
				int tot = c.bitCount();
				if (tot == max) {
					count++;
				} else if (tot > max) {
					max = tot;
					count = 1;
				}
			}
		}
		int result[] = new int[2];
		result[0] = max;
		result[1] = count;
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		String[] topic = new String[n];

		for (int i = 0; i < n; i++) {
			String topicItem = scanner.nextLine();
			topic[i] = topicItem;
		}

		int[] result = acmTeam(topic);

		for (int i = 0; i < result.length; i++) {
			// bufferedWriter.write(String.valueOf(result[i]));
			System.out.print(result[i] + " ");
			if (i != result.length - 1) {
				// bufferedWriter.write("\n");
			}
		}

		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}

}
