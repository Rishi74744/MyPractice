package com.questions.hackerrank;

import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String S = in.next();
		int strLen = S.length();
		int subStrStart = 0;
		int subStrEnd = 3;
		int count = 0;
		while(strLen != 0){
			String subString[] = S.substring(subStrStart, subStrEnd).split("");
			if(!subString[0].equals("S")){
				count++;
			}
			if(!subString[1].equals("O")){
				count++;
			}
			if(!subString[2].equals("S")){
				count++;
			}
			subStrStart += 3;
			subStrEnd += 3;
			strLen -= 3;
		}
		System.out.println(count);
	}

}
