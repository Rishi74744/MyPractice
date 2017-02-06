package com.questions.hackerrank;

import java.util.Scanner;

public class JumpingOnTheCloudsRevisited {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int c[] = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}
		int currentPos = 0;
		int count = 0;
		int e = 100;
		while (count != 1) {
			int nextPos = (currentPos + k) % n;
			if(c[nextPos] == 0){
				e--;
			}else{
				e-=3;
			}
			currentPos = nextPos;
			if (nextPos == 0) {
				count++;
			}
		}
		System.out.println(e);
	}

}
