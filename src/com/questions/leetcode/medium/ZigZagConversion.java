package com.questions.leetcode.medium;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		String list[] = new String[numRows];
		int j = 0;
		int i = 0;
		boolean isDown = true;
		if (numRows == 1 || numRows >= s.length()) {
			return s;
		}
		while (i != s.length()) {
			String row = list[j];
			if (row == null) {
				row = s.charAt(i) + "";
			} else {
				row = row + s.charAt(i);
			}
			list[j] = row;
			if (j == numRows - 1 && isDown) {
				isDown = false;
			} else if (j == 0 && !isDown) {
				isDown = true;
			}
			if (isDown) {
				j++;
			} else {
				j--;
			}
			i++;
		}
		return String.join("", list);
	}

	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert("PAYPAL", 2));
	}
}
