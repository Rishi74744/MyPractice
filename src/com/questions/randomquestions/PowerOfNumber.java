package com.questions.randomquestions;

public class PowerOfNumber {

	static int findPower(int a, int n) {
		int power[] = new int[n + 1];
		power[0] = 0;
		power[1] = a;
		for (int i = 2; i <= n; i++) {
			power[i] = power[i - 1] * a;
		}
		return power[n];
	}

	public static void main(String[] args) {
		System.out.println(findPower(2, 7));
	}

}
