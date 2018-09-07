package com.questions.randomquestions;

public class TrailingZeroesInFactorial {

	public static void main(String args[]) {
		int number = 3125;
		int i = 1;
		int zeroes = 0;
		int pow = (int) Math.pow(5, i);
		while (pow <= number) {
			int x = number / pow;
			zeroes = zeroes + x;
			i++;
			pow = (int) Math.pow(5, i);
		}
		System.out.println(zeroes);
	}

}
