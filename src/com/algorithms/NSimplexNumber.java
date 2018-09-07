package com.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class NSimplexNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		ArrayList<Integer> result = getRow(k);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	/*
	 * public static ArrayList<Integer> getRow(int k) { ArrayList<Integer>
	 * result = new ArrayList<>(); for (int i = 0; i <= k; i++) { int prod =
	 * calculateProduct((k - i) + 1, i); int fact = factorial(i); int d = prod /
	 * fact; result.add(i, d); }
	 * 
	 * return result; }
	 * 
	 * static int calculateProduct(int n, int k) { int prod = 1; for (int i = 0;
	 * i < k; i++) { prod = prod * (n + i); } return prod; }
	 * 
	 * static int factorial(int n) { int prod = 1; for (int i = 1; i <= n; i++)
	 * { prod = prod * i; } return prod; }
	 */

	static ArrayList<Integer> getRow(int k) {
		ArrayList<Integer> result = new ArrayList<>();
		result.ensureCapacity(k + 1);
		// BigInteger result[] = new BigInteger[k + 1];
		int i = 0;
		int j = k;
		while (i <= j) {
			BigInteger prod = calculateProduct((k - i) + 1, i);
			BigInteger fact = factorial(i);
			BigInteger d = prod.divide(fact);
			result.add(i, new Integer(d.intValue()));
			if (i != j) {
				result.add(j, new Integer(d.intValue()));
			}
			i++;
			j--;
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