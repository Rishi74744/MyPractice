package com.java.hackerrank.dynamic.programming;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciModified {

	static Map<BigInteger, BigInteger> m = new HashMap<>();

	static BigInteger fibonacciModified(int t1, int t2, int n) {
		m.put(BigInteger.ZERO, new BigInteger(Integer.toString(t1)));
		m.put(BigInteger.ONE, new BigInteger(Integer.toString(t2)));
		return fib(n - 1);
	}

	static BigInteger fib(int n) {
		if (n == 0 || n == 1) {
			return m.get(new BigInteger(Integer.toString(n)));
		}
		if (!m.containsKey(n)) {
			BigInteger t1 = fib(n - 2);
			BigInteger t2 = fib(n - 1).pow(2);
			BigInteger sum = t1.add(t2);
			m.put(new BigInteger(Integer.toString(n)), sum);
		}
		return m.get(new BigInteger(Integer.toString(n)));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*
		 * String[] t1T2n = scanner.nextLine().split(" ");
		 * 
		 * int t1 = Integer.parseInt(t1T2n[0]);
		 * 
		 * int t2 = Integer.parseInt(t1T2n[1]);
		 * 
		 * int n = Integer.parseInt(t1T2n[2]);
		 */

		BigInteger result = fibonacciModified(0, 1, 10);
		System.out.println("Result : " + result);

		scanner.close();
	}

}