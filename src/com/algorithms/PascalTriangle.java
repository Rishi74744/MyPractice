package com.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
		for (int i = 0; i < k + 1; i++) {
			finalResult.add(getRow(i));
		}
		System.out.println(finalResult);
	}

	public static ArrayList<Integer> getRow(int k) {
		ArrayList<Integer> result = new ArrayList<>();
		// int i = 0;
		// int j = k;
		for (int i = 0; i <= k; i++) {
			BigInteger prod = calculateProduct((k - i) + 1, i);
			BigInteger fact = factorial(i);
			BigInteger d = prod.divide(fact);
			result.add(new Integer(d.intValue()));
		}
		return result;
	}

	static BigInteger calculateProduct(int n, int k) {
		BigInteger prod = BigInteger.ONE;
		for (int i = 0; i < k; i++) {
			prod = prod.multiply(BigInteger.valueOf(n).add(BigInteger.valueOf(i)));
		}
		return prod;
	}

	static BigInteger factorial(int n) {
		BigInteger prod = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			prod = prod.multiply(BigInteger.valueOf(i));
		}
		return prod;
	}
}
