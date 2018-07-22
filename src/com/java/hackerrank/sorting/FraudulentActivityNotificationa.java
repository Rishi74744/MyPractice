package com.java.hackerrank.sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FraudulentActivityNotificationa {

	// Complete the activityNotifications function below.
	static int activityNotifications(int[] expenditure, int d) {
		int notifications = 0;
		for (int i = d, j = 0; i < expenditure.length; i++, j++) {
			int ar[] = Arrays.copyOfRange(expenditure, j, i);
			Arrays.sort(ar);
			int median = 0;
			if (d % 2 == 0) {
				median = (ar[d / 2] + ar[(d / 2) + 1]) / 2;
			} else {
				median = ar[d / 2];
			}
			if (expenditure[i] >= (2 * median)) {
				notifications++;
			}
		}
		return notifications;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] expenditure = new int[n];

		String[] expenditureItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);
		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}

}
