package com.questions.leetcode.amazon.prep;

public class RepeatedSubstringPattern {

	public static boolean repeatedSubstringPattern(String s) {
		int i = 1;
		int n = s.length();
		int rps[] = new int[n];
		int prev = 0;
		while (i < n) {
			if (s.charAt(i) == s.charAt(prev)) {
				rps[i++] = ++prev;
			} else if (prev == 0) {
				rps[i++] = 0;
			} else {
				prev = rps[prev - 1];
			}
		}
		return rps[n - 1] > 0 && n % (n - rps[n - 1]) == 0;
	}

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("ababab"));
	}

}
