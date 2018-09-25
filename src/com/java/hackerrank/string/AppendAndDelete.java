package com.java.hackerrank.string;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AppendAndDelete {

	/*
	 * static String appendAndDelete(String s, String t, int k) { if (s.length()
	 * + t.length() <= k) { return "Yes"; } if (s.equals(t)) { if (((2 *
	 * s.length()) <= k)) { return "Yes"; } else { return "No"; } } Set<String>
	 * eleS = new HashSet<>(Arrays.asList(s.split(""))); Set<String> eleT = new
	 * HashSet<>(Arrays.asList(t.split(""))); eleS.removeAll(eleT); if
	 * (s.length() > t.length() && eleS.isEmpty()) { return "Yes"; } int i = 0;
	 * int j = 0; int common = 0; while (i != s.length() && j != t.length()) {
	 * if (s.charAt(i) == t.charAt(j)) { i++; j++; common++; } else { break; } }
	 * int sLeft = s.length() - i; int tLeft = t.length() - j; if ((sLeft +
	 * tLeft) != k) { if ((sLeft + tLeft + common) == k) { return "Yes"; }
	 * return "No"; } else { return "Yes"; } }
	 */

	static String appendAndDelete(String s, String t, int k) {
		if (s.equals(t)) {
			if ((s.length() + t.length()) <= k) {
				return "Yes";
			} else {
				return "No";
			}
		}
		return t;
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
