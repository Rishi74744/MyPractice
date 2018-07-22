package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ClimbingTheLeaderboard {

	// Complete the climbingLeaderboard function below.
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int result[] = new int[alice.length];
		Arrays.fill(result, 1);
		int lastPos = 1;
		int s[] = Arrays.stream(scores).distinct().toArray();
		lastPos = s.length;
		for (int i = 0, j = lastPos - 1; i < alice.length; i++) {
			while (j >= 0) {
				if (alice[i] < s[j]) {
					result[i] = lastPos + 1;
					break;
				} else if (alice[i] == s[j]) {
					result[i] = lastPos;
					break;
				} else {
					if (alice.length - 1 == i) {
						result[i] = 1;
					}
					j--;
					lastPos--;
				}
			}
		}

		/*
		 * int lastSco = 0; for (int i = 0; i < alice.length; i++) { lastPos =
		 * 1; for (int j = 0; j < scores.length; j++) { if (alice[i] >=
		 * scores[j]) { if (lastPos == 1 && j == 0) { result[i] = lastPos; }
		 * else { result[i] = lastPos + 1; } break; } else if (lastSco >
		 * scores[j]) { lastPos++; } if (j == scores.length - 1) { result[i] =
		 * lastPos + 1; break; } lastSco = scores[j]; } }
		 */
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int scoresCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[scoresCount];

		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < scoresCount; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}

		int aliceCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] alice = new int[aliceCount];

		String[] aliceItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < aliceCount; i++) {
			int aliceItem = Integer.parseInt(aliceItems[i]);
			alice[i] = aliceItem;
		}

		int[] result = climbingLeaderboard(scores, alice);

		for (int i = 0; i < result.length; i++) {
			// bufferedWriter.write(String.valueOf(result[i]));
			System.out.println(result[i]);
			// if (i != result.length - 1) {
			// bufferedWriter.write("\n");
			// }
		}

		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}

}
