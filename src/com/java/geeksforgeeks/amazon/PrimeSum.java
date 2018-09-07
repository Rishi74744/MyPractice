package com.java.geeksforgeeks.amazon;

import java.util.Scanner;

public class PrimeSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(sieveOfEratosthenes(n));
	}

	public static int sieveOfEratosthenes(int n) {
		int sum = 0;
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i < n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * 2; i <= n; i += p)
					prime[i] = false;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (prime[i] == true) {
				sum = sum + i;
			}
		}
		return sum;
	}

}
