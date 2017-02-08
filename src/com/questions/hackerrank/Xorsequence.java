package com.questions.hackerrank;

import java.util.Scanner;


public class Xorsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
			long L = sc.nextLong();
			long R = sc.nextLong();
			System.out.println((G(R)^G(L-1)));
		}
	}

	static long G(long x){
	    long a = x % 8;
	    if(a == 0 || a == 1) return x;
	    if(a == 2 || a == 3) return 2;
	    if(a == 4 || a == 5) return x+2;
	    if(a == 6 || a == 7) return 0;
	    return 0;
	}

}