package com.questions.leetcode.medium;

public class ZigZagConversion2 {

	public String convert(String s, int numRows) {
		StringBuilder finalString = new StringBuilder();
		int i = 0;
		if (numRows == 1 || numRows >= s.length()) {
			return s;
		}
		while (i <= numRows) {
			for (int j = i; j < s.length(); j = j + (2 * numRows) - 2) {
				finalString.append(s.charAt(j));
			}
			i++;
		}
		return finalString.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion2 z = new ZigZagConversion2();
		System.out.println(z.convert("PAYPALISHIRING", 3));
	}
}
