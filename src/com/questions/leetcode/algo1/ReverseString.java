package com.questions.leetcode.algo1;

public class ReverseString {

	public static void reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;
		while (i <= j) {
			char cur = s[i];
			s[i] = s[j];
			s[j] = cur;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		char[] s = { 'H', 'a', 'n', 'n', 'a', 'h' };
		reverseString(s);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

}
