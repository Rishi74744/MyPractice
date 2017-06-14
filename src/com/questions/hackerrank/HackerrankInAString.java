package com.questions.hackerrank;

import java.util.Scanner;

public class HackerrankInAString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		String reqSubstring = "hackerrank";
		char hackarr[] = reqSubstring.toCharArray();
		for (int w = 0; w < q; w++) {
			String s = sc.next();
			boolean hack[] = new boolean[10];
			for (int i = 0; i < 10; i++) {
				hack[i] = false;
			}
			char ar[] = s.toCharArray();
			int c = 0, i = 0;
			boolean isAll = false;
			while (c != ar.length) {
				if (ar[c] == hackarr[i]) {
					hack[i] = true;
					if (i == 9) {
						isAll = true;
					}
					i++;
					if (i == 10) {
						break;
					}
				}
				c++;
			}
			if (isAll) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
