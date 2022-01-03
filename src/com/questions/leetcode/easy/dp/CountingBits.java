package com.questions.leetcode.easy.dp;

public class CountingBits {

	public static int[] countBits(int n) {
		int output[] = new int[n + 1];
		output[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			boolean isPowerOfTwo = (int) Math.ceil((Math.log(i) / Math.log(2))) == (int) Math
					.floor((Math.log(i) / Math.log(2)));
			if (isPowerOfTwo) {
				output[i] = 1;
				continue;
			}
			double sqrt = Math.sqrt(i);
			if (sqrt % 1 > 0.5) {
				output[i] = (int) Math.ceil(sqrt);
			} else {
				output[i] = (int) Math.floor(sqrt);
			}
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println((int) Math.ceil((Math.log(9) / Math.log(2))));
		int out[] = countBits(16);
		for (int i = 0; i < out.length; i++) {
			System.out.println(i + "----" +out[i]);
		}
	}

}
