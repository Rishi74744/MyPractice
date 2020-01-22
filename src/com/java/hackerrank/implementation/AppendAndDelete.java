package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class AppendAndDelete {

	static String appendAndDelete(String s, String t, int k) {
		char s1[] = s.toCharArray();
		char t1[] = t.toCharArray();
		if (s.equals(t)) {
			return "Yes";
		}
		int lenDiff = Math.abs(s.length() - t.length());
		if (lenDiff > k) {
			return "No";
		}
		int totalSteps = 0;
		for (int i = 0; i < t1.length && i < s1.length; i++) {
			if (s1[i] != t1[i]) {
				totalSteps = t1.length - i + (s1.length - i);
				break;
			}
		}
		if (totalSteps == k || lenDiff * 2 == k) {
			return "Yes";
		}
		return "No";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scanner.nextLine();

		String t = scanner.nextLine();

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = appendAndDelete(s, t, k);

		System.out.println(result);
		scanner.close();
	}

}