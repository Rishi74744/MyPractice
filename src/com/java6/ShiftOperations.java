package com.java6;

public class ShiftOperations {

	public static void main(String[] args) {
		int oldCapacity = 12;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		System.out.println(newCapacity);

		newCapacity = oldCapacity + (oldCapacity << 1);
		System.out.println(newCapacity);
	}
}
