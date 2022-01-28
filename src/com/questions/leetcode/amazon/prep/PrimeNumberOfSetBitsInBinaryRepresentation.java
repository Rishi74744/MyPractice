package com.questions.leetcode.amazon.prep;

public class PrimeNumberOfSetBitsInBinaryRepresentation {

	public static int countPrimeSetBits(int left, int right) {
		boolean isPrime[] = new boolean[20];
		for (int i = 2; i <= right; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i < right; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < right; j += i) {
					isPrime[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = left; i <= right; i++) {
			int j = Integer.bitCount(i);
			if (isPrime[j]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimeSetBits(1, 15));
	}
}
