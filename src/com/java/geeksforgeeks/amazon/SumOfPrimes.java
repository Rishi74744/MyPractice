package com.java.geeksforgeeks.amazon;

import java.util.Scanner;

public class SumOfPrimes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		findPrimePair(n);
		scanner.close();
	}

	static void findPrimePair(int n) {
		boolean isPrime[] = new boolean[n + 1];
		sieveOfEratosthenes(n, isPrime);
		for (int i = 0; i < n; i++) {
			if (isPrime[i] && isPrime[n - i]) {
				System.out.print(i + " " + (n - i));
				return;
			}
		}
	}

	static boolean sieveOfEratosthenes(int n, boolean isPrime[]) {
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= n; i++)
			isPrime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (isPrime[p] == true) {
				for (int i = p * 2; i <= n; i += p)
					isPrime[i] = false;
			}
		}
		return false;
	}

}
