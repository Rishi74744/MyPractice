package com.java.hackerrank.string;

import java.io.IOException;
import java.util.Scanner;

public class StrongPassword {

	static int minimumNumber(int n, String password) {
		String numRegEx = ".*\\d+.*";
		String lowerCaseRegEx = ".*[a-z].*";
		String upperCaseRegEx = ".*[A-Z].*";
		String symbolRegEx = ".*[!@#$%^&\\-*()+].*";
		int count = 0;
		int lenCount = 0;
		if (password.length() < 6) {
			lenCount = 6 - password.length();
		}
		if (!password.matches(numRegEx)) {
			count++;
		}
		if (!password.matches(lowerCaseRegEx)) {
			count++;
		}
		if (!password.matches(upperCaseRegEx)) {
			count++;
		}
		if (!password.matches(symbolRegEx)) {
			count++;
		}
		if (lenCount <= count) {
			return count;
		} else {
			return lenCount;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String password = scanner.nextLine();

		int answer = minimumNumber(n, password);

		System.out.println(answer);

		scanner.close();
	}

}