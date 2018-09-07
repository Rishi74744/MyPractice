package com.java.geeksforgeeks.amazon;

import java.util.Scanner;

/**
 * Given a decimal number m, convert it into a binary string and apply n
 * iterations, in each iteration 0 becomes “01” and 1 becomes “10”. Find
 * ith(based indexing) index character in the string after nth iteration.
 * 
 */
public class FindithIndex {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int ithIndex = scanner.nextInt();
		int blockNumber = m / (2 ^ n);
		String binaryNumber = Integer.toBinaryString(m);
		String binary[] = binaryNumber.split("");
		String blockNum[] = { binary[blockNumber] };
		StringBuilder convertedBinary = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < blockNum.length; j++) {
				if ("1".equals(blockNum[i])) {
					convertedBinary.append("10");
				} else {
					convertedBinary.append("01");
				}
			}
			blockNum = convertedBinary.toString().split("");
		}
		System.out.println(blockNum[ithIndex]);
	}

}