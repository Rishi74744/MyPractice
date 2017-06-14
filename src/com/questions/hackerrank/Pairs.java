package com.questions.hackerrank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		BigInteger k = in.nextBigInteger();
		BigInteger[] ar = new BigInteger[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextBigInteger();
		}
		Arrays.sort(ar);
		int count = 0;
		int i = 0, j = 1;
		while (j < n) {
			BigInteger diff = ar[i].subtract(ar[j]);
			if(diff.signum() == -1){
				diff = diff.negate();
			}
			int result = diff.compareTo(k);
			switch (result) {
			case -1:
				j++;
				break;
			case 0:
				count++;
				i++;
				break;
			case 1:
				i++;
				break;
			default:
			}
		}
		System.out.println(count);
	}

}
