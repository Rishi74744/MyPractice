package com.java8.lambda.udemy;

public class RunnableExample {

	public static void main(String[] args) {
		Runnable runnableLambda = () -> {
			System.out.println("Hello");
		};
		new Thread(runnableLambda).start();
	}

}
