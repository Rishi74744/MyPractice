package com.questions.hackerrank;
import java.util.Scanner;

public class SumVsXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		if(n>0){
			long p = Long.toBinaryString(n).length()-Long.bitCount(n);
			System.out.println((long)Math.pow(2,p));
		}else{
			System.out.println(1);
		}
	}

}
