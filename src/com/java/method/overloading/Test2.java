package com.java.method.overloading;

public class Test2 extends Test1 {

	void sum(float a) {
		System.out.println("Sum with float a");
	}

	public void sum(double a, double d) {
		System.out.println("Sum with double a, double d");
	}

	protected void sum(float d, float a) {
		System.out.println("Sum with float d, float a");
	}

	private void sum(int f, int a) {
		System.out.println("Sum with int f, int a");
	}

	public static void main(String[] args) {
		new Test1().sum(10f, 10);
		new Test2().sum(10f, 10d);
		new Test2().sum(10, 10);
	}

}