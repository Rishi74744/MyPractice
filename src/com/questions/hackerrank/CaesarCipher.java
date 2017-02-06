package com.questions.hackerrank;

import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int k = in.nextInt();
		int num = 26;
		StringBuilder finalString = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			
			if (((char) s.charAt(i) >= 65 && (char) s.charAt(i) <= 90) || (char) s.charAt(i) >= 97 && (char) s.charAt(i) <= 122) {
				int p = (char) s.charAt(i) + (k % num);
				if ((char) s.charAt(i) < 91 && p > 90) {
					int x = 0;
					x = p - 90;						
					p = 64 + x;
				} else if ((char) s.charAt(i) < 123 && p > 122) {
					int x = 0;
					x = p - 122;						
					p = 97 + x;
				}
				finalString.append((char) p);
			} else {
				finalString.append(s.charAt(i));
			}

		}
		System.out.println(finalString);
	}
}