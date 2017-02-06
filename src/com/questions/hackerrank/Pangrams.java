package com.questions.hackerrank;

import java.util.Scanner;

public class Pangrams {

	private static final int NO_OF_LETTERS_OF_ALPHABET = 26;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if(isPangram(s)){
			System.out.println("pangram");
		}else{
			System.out.println("not pangram");
		}
	}

	private static boolean isPangram(String s) {
		if (s.length() < NO_OF_LETTERS_OF_ALPHABET) {
			return false;
		}
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			if (s.indexOf(ch) < 0 && s.indexOf((char) (ch + 32)) < 0) {
				return false;
			}
		}
		return true;
	}
	
}
