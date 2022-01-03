package com.java8.functional.interfaces.udemy;

import java.util.function.Predicate;

public class PredicateExample {
	static Predicate<Integer> p1 = (i) -> i % 2 == 0;
	static Predicate<Integer> p2 = (i) -> i % 5 == 0;

	public static void predicateAnd() {
		System.out.println(p1.and(p2).test(20));
	}

	public static void predicateOr() {
		System.out.println(p1.or(p2).test(45));
	}

	public static void predicateNegate() {
		System.out.println(p1.or(p2).negate().test(23));
	}

	public static void main(String[] args) {
		predicateAnd();
		predicateOr();
		predicateNegate();
	}

}
