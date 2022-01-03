package com.java.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class NB {
	Optional<String> bn;

	public NB(Optional<String> n) {
		bn = n;
	}

	public Optional<String> getName() {
		return bn;
	}
}

public class MyClass {

	public static void main(String[] args) {
		NB n = new NB(Optional.ofNullable(null));
		Optional<String> bn = n.getName();
//		bn.ifPresent(System.out::println).orElse("Empty");
	}

}
