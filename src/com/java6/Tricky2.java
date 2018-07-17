package com.java6;

public class Tricky2 {

	public static void main(String[] args) {
		long longWithL = 1000 * 60 * 60 * 24 * 365L;
		long longWithoutL = 1000 * 60 * 60 * 24 * 365;
		System.out.println(longWithL);
		System.out.println(longWithoutL);
	}

}
