package com.java8.functional.interfaces.udemy;

import java.util.function.BiConsumer;

public class BiConsumerExample {

	public static void main(String[] args) {
		BiConsumer<String, String> bi = (a, b) -> {
			System.out.println(a + " " + b);
		};
		bi.accept("a", "b");
	}

}
