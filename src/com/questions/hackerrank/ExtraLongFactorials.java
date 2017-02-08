package com.questions.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger();
		BigInteger fact = BigInteger.ONE;
		while(!BigInteger.ONE.equals(n)){
			fact = fact.multiply(n);
			n = n.subtract(BigInteger.ONE);
		}
		System.out.println(fact);
	}

}
