package com.questions.hackerrank;

import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			long x = sc.nextLong();
			String b = Long.toBinaryString(Integer.toUnsignedLong((int) x) | 0x100000000L).substring(1);
			StringBuilder str = new StringBuilder();
			int c = 0;
			while (c != b.length()) {
				if (Character.toString(b.charAt(c)).equals("0")) {
					str.append("1");
				} else {
					str.append("0");
				}
				c++;
			}
			System.out.println(Long.parseLong(str.toString(), 2));
		}
	}
}
