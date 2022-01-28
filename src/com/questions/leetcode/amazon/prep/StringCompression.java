package com.questions.leetcode.amazon.prep;

public class StringCompression {

	public static int compress(char[] chars) {
		int charCount = 1;
		char currentChar = chars[0];
		int resultCount = 0;
		StringBuilder res = new StringBuilder();
		for (int i = 1; i < chars.length; i++) {
			if (currentChar == chars[i]) {
				charCount++;
			} else {
				res.append(currentChar);
				if (charCount > 1) {
					res.append(Integer.toString(charCount));
				}
				currentChar = chars[i];
				charCount = 1;
			}
		}
		res.append(currentChar);
		if (charCount > 1) {
			res.append(Integer.toString(charCount));
		}
		for (int i = 0; i < res.length(); i++) {
			chars[i] = res.charAt(i);
		}
		return resultCount;
	}

	public static void main(String[] args) {
		char[] chars = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', };
		System.out.println(compress(chars));
	}

}
