package com.java.hackerrank.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifiedKaprekarNumbers {

	// Complete the kaprekarNumbers function below.
	static void kaprekarNumbers(int p, int q) {
		List<Long> res = new ArrayList<>();
		for (long i = p; i <= q; i++) {
			int d = (i + "").length();
			String sq = (i * i) + "";
			String s[] = sq.split("");
			StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
			long l = 0;
			long r = 0;
			int len = s.length - d;
			if (len < 0) {
				System.out.println(len + " " + i);
			}
			for (int j = len; j < s.length; j++) {
				s1.append(s[j]);
			}
			for (int j = 0; j < len; j++) {
				s2.append(s[j]);
			}
			if (!s1.toString().isEmpty()) {
				r = Integer.parseInt(s1.toString());
			}
			if (!s2.toString().isEmpty()) {
				l = Integer.parseInt(s2.toString());
			}
			if ((l + r) == i) {
				res.add(i);
			}
		}
		if (res.isEmpty()) {
			System.out.print("INVALID RANGE");
		} else {
			for (int i = 0; i < res.size(); i++) {
				System.out.print(res.get(i));
				if (i != res.size() - 1) {
					System.out.print(" ");
				}
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		kaprekarNumbers(p, q);

		scanner.close();
	}

}
