package com.questions.leetcode.amazon.prep;

public class CountPrimes {

	public static int countPrimes(int n) {
		boolean isPrime[] = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < isPrime.length; i++) {
			if (i < n && isPrime[i]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(9));
	}

}
