package com.java.prep.bit.manupulation;

public class CountSetBits {

	public int countSetBits(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int x = i;
			while (x > 0) {
				x = x & (x - 1);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountSetBits c = new CountSetBits();
		System.out.println(c.countSetBits(4));
	}
}
