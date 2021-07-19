package com.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class AppendAndDelete {

	static String appendAndDelete(String s, String t, int k) {
		boolean isSame = true;
		int i = 0;
		if (s.equals(t)) {
			if (k >= (s.length() * 2)) {
				return "Yes";
			} else {
				if (k % 2 == 0) {
					return "Yes";
				} else {
					return "No";
				}
			}
		}
		while (isSame) {
			if (s.charAt(i) != t.charAt(i)) {
				isSame = false;
			}
			i++;
			if (i == s.length() || i == t.length()) {
				break;
			}
		}
		int total = (s.length() - i + 1) + (t.length() - i + 1);
		if (total == k) {
			return "Yes";
		} else if (total > k) {
			return Math.abs(total - k) % 2 == 0 ? "Yes" : "No";
		} else {
			return "No";
		}
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