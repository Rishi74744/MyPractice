package com.java.designpatterns.decorator;

public class DecoratorDemo {

	public static void main(String[] args) {
		Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
		System.out.println(sandwich.make());
	}

}
