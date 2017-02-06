package com.questions.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class Countergame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			BigInteger n = sc.nextBigInteger();
			String b = n.toString(2);
			int c = 0;
			int numOfOnes = 0;
			while(c != b.length()){
				if (Character.toString(b.charAt(c)).equals("1")) {
					numOfOnes++;
				}
				c++;
			}
			c--;
			int numOfTrailingZeros = 0;
			while(c!=0){
				if (Character.toString(b.charAt(c)).equals("0")) {
					numOfTrailingZeros++;
				}else{
					break;
				}
				c--;
			}
			int totalMoves = numOfOnes + numOfTrailingZeros - 1;
			if(totalMoves % 2 == 0){
				System.out.println("Richard");
			}else{
				System.out.println("Louise");
			}
		}
	}

}


/**
TestCase - 9034272882268244365 - Richard*/