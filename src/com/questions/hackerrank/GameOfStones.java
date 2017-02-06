package com.questions.hackerrank;

import java.util.Scanner;

public class GameOfStones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int noOfStones = sc.nextInt();
			if(noOfStones % 7 == 0 || noOfStones % 7 == 1){
				System.out.println("Second");
			}else{
				System.out.println("First");
			}
		}
	}

}
