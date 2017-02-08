package com.questions.hackerrank;

import java.util.Scanner;

public class SherlockandSquares {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
			long a = sc.nextLong();
			long b = sc.nextLong();
			double count = Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1;
			System.out.println((int)count);
		}
	}

}
