package com.java.ops;

public class BitwiseXOR {

	static void bitwiseXOR(int x, int y, int n) {
		System.out.println(x ^ y);
		System.out.println((x ^ y) % n);
	}

	public static void main(String[] args) {
		bitwiseXOR(39860001, 0, 100000);
	}

}
