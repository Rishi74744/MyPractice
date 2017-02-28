package com.questions.hackerrank.projecteuler;

import java.math.BigInteger;
import java.util.Scanner;

public class EvenFibonaccinumbers {
	
	private static BigInteger k;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger t = in.nextBigInteger();
		while(!BigInteger.ZERO.equals(t)){
			k = in.nextBigInteger();
			
		}
	}
	
	private static BigInteger findEvenFibonacci(BigInteger n){
		if(BigInteger.ONE.compareTo(n)<0){
			return n.add(BigInteger.ONE);
		}
		if(BigInteger.ONE.equals(n)){
			return BigInteger.valueOf(2);
		}
		BigInteger sum = BigInteger.ZERO;
		BigInteger value = ((BigInteger.valueOf(4).multiply(findEvenFibonacci(n.subtract(BigInteger.ONE)))).add((findEvenFibonacci(n.subtract(BigInteger.valueOf(2))))));
		
		sum = sum.add(value);
		return sum;
	}
	

}
