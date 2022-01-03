package com.java8.lambda.expressions;

public class Greeter {

	
	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeting greeting = () -> System.out.println("Hello World");
		greeting.perform();
		
	}
	
}

interface MyLambda {
	void foo();
}