package com.java8.lambda.udemy;

import java.util.Comparator;

public class ComparatorExample {

	public static void main(String[] args) {
		Comparator<Integer> comp = (Integer o1, Integer o2) -> {
			return o1.compareTo(o2);
		};
		System.out.println(comp.compare(10, 10));
	}

}
