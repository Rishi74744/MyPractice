package com.questions.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger n = sc.nextBigInteger();
		BigInteger count = n.subtract(BigInteger.valueOf(2));
		BigInteger f = BigInteger.ZERO;
		while(!BigInteger.ZERO.equals(count)){
			f = calculateTerm(a, b);
			a = b;
			b = f;
			count = count.subtract(BigInteger.valueOf(1));
		}
		System.out.println(f);
	}

	public static BigInteger calculateTerm(BigInteger a, BigInteger b){
		return a.add(b.pow(2));
	}
}
