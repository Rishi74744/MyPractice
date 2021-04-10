package com.java.hackerrank.implementation;

import java.io.IOException;

public class HalloweenSale {

	static int howManyGames(int p, int d, int m, int s) {
		// Return the number of games you can buy
		if (s < p) {
			return 0;
		}
		if (s == p) {
			return 1;
		}
		int sum = 0;
		int currentPrice = p;
		int count = 0;
		while (currentPrice >= m && sum < s) {
			sum = sum + currentPrice;
			currentPrice = currentPrice - d;
			count++;
		}
		System.out.println(count);
		int remainingPrice = s - sum;
		
        System.out.println(remainingPrice);
		int r = remainingPrice / m;
		return count + r;
	}

	public static void main(String[] args) throws IOException {
		String[] pdms = "100 19 1 180".split(" ");

		int p = Integer.parseInt(pdms[0]);

		int d = Integer.parseInt(pdms[1]);

		int m = Integer.parseInt(pdms[2]);

		int s = Integer.parseInt(pdms[3]);

		int answer = howManyGames(p, d, m, s);

		System.out.println(answer);
	}

}
