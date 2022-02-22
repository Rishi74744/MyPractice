package com.java.prep.bit.manupulation;

public class FindMSB {

	public static int findMSB(int n) {
		int k = (int) (Math.log(n) / Math.log(2));
		return 1 << k;
	}

	public static void main(String[] args) {
		System.out.println(findMSB(265));
	}

}
