package com.questions.hackerrank;

import java.util.Scanner;

public class CamelCase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			if((char)s.charAt(i) >= 65 && (char)s.charAt(i) <= 90){
				k++;
			}
		}
		System.out.println(k+1);
	}

}
