package com.questions.randomquestions;

public class PrincetonSolutionToKthPermutation {

	private static int j = 0;
	private static int k = 2;

	public static void perm(String s) {
		perm("", s);
	}

	private static void perm(String prefix, String s) {
		int N = s.length();
		if (N == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < N; i++) {
				perm(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N));
			}
		}
	}

	public static void main(String[] args) {
		String alphabet = "abc";
		int n = alphabet.length();
		String elements = alphabet.substring(0, n);
		perm(elements);
	}

}
