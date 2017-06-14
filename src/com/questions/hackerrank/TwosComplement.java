package com.questions.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class TwosComplement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			BigInteger a = scanner.nextBigInteger();
			BigInteger b = scanner.nextBigInteger();
			BigInteger c = a;
			while (c.compareTo(b) == -1 || c.compareTo(b) == 0) {
				String s1 = c.toString(2);
				flipBits(s1);
				System.out.println(s1);
				c = c.add(BigInteger.ONE);
			}
		}
	}

	public static void flipBits(String s1) {
		StringBuilder onesComp = new StringBuilder();
		StringBuilder paddedBin = new StringBuilder();
		if (s1.length() < 32) {
			for (int j = 0; j <= (32 - s1.length()); j++) {
				paddedBin.append("0");
			}
			paddedBin.append(s1);
		}
		s1 = paddedBin.toString();
		int i = 0;

		while (i != s1.length()) {
			if (s1.charAt(i) == '1') {
				onesComp.append("0");
			} else {
				onesComp.append("1");
			}
			i++;
		}
		s1 = onesComp.toString();
	}

}
