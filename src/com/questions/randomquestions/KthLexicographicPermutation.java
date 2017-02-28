package com.questions.randomquestions;

import java.util.Scanner;

public class KthLexicographicPermutation {

	static int k;
	static int j = 0;
	static String finalOutput;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		k = sc.nextInt();
		StringBuilder missingString = new StringBuilder();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (s2.indexOf(ch) < 0) {
				missingString.append(ch);
			}
		}

		permuteString("", missingString.toString());
		System.out.println("Output :" + finalOutput);
	}

	public static void permuteString(String beginningString, String endingString) {
		if(j <= k){
			if (endingString.length() <= 1) {
				finalOutput = beginningString + endingString;
				System.out.println(finalOutput);
			} else {
				for (int i = 0; i < endingString.length(); i++) {
					try {
						String newString = endingString.substring(0, i) + endingString.substring(i + 1);
						permuteString(beginningString + endingString.charAt(i), newString);
					} catch (StringIndexOutOfBoundsException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}

}
