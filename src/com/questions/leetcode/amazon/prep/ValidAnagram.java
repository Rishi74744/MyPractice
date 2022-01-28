package com.questions.leetcode.amazon.prep;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if (s.length() < t.length()) {
			return false;
		}
		int anagram[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			anagram[Character.getNumericValue(s.charAt(i)) - 10]++;

		}
		for (int i = 0; i < t.length(); i++) {
			anagram[Character.getNumericValue(t.charAt(i)) - 10]--;
		}
		for (int i = 0; i < anagram.length; i++) {
			if (anagram[i] > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
	}

}
