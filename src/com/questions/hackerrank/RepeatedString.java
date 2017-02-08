package com.questions.hackerrank;

import java.util.Scanner;

public class RepeatedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		long n = in.nextLong();
		String[] str = s.split("");
		int strLen = str.length;
		int numOfA = 0;
		for (int i = 0; i < strLen; i++) {
			if ("a".equalsIgnoreCase(str[i])) {
				numOfA++;
			}
		}
		long totalA = 0;
		if (numOfA == 0) {
			totalA = 0;
		} else if (numOfA == 1 && strLen == 1) {
			totalA = numOfA * (int) n;
		} else {
			if (n < (strLen - 1)) {
				long stringtoItr = (strLen - 1) - (int) n + 1;
				for (int i = 0; i < stringtoItr; i++) {
					if ("a".equalsIgnoreCase(str[i])) {
						totalA++;
					}
				}
			} else if (n > (strLen - 1)) {
				long numOfRep = n / (strLen - 1);
				totalA = numOfRep * numOfA;
				long stringtoItr = n - (numOfRep * (strLen - 1)) + 1;
				for (int i = 0; i < stringtoItr; i++) {
					if ("a".equalsIgnoreCase(str[i])) {
						totalA++;
					}
				}
			} else {
				totalA = numOfA;
			}
		}
		System.out.println(totalA);
	}
}
