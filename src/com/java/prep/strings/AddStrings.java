package com.java.prep.strings;

public class AddStrings {

	public String addStrings(String num1, String num2) {
		int carry = 0;
		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;
		StringBuilder add = new StringBuilder();
		while (len1 >= 0 && len2 >= 0) {
			int s = (num2.charAt(len2) - '0') + (num1.charAt(len1) - '0') + carry;
			if (s >= 10) {
				carry = 1;
				s = s - 10;
			} else {
				carry = 0;
			}
			add.append(s);
			len1--;
			len2--;
		}
		if (len1 < 0 && len2 >= 0) {
			while (len2 >= 0) {
				int s = (num2.charAt(len2) - '0') + carry;
				if (s >= 10) {
					carry = 1;
					s = s - 10;
				} else {
					carry = 0;
				}
				add.append(s);
				len2--;
			}
		}
		if (len1 >= 0 && len2 < 0) {
			while (len1 >= 0) {
				int s = (num1.charAt(len1) - '0') + carry;
				if (s >= 10) {
					carry = 1;
					s = s - 10;
				} else {
					carry = 0;
				}
				add.append(s);
				len1--;
			}
		}
		if (carry > 0) {
			add.append(carry);
		}
		return add.reverse().toString();
	}

	public static void main(String[] args) {
		AddStrings s = new AddStrings();
		System.out.println(s.addStrings("0", "0"));
	}

}
