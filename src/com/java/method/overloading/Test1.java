package com.java.method.overloading;

public class Test1 {

	void sum(int a) {
		System.out.println("Sum with int a");
	}

	public void sum(int a, double d) {
		System.out.println("Sum with int a, double d");
	}

	protected void sum(double d, int a) {
		System.out.println("Sum with double d, int a");
	}

	final private void sum(float f, int a) {
		System.out.println("Sum with float f, int a");
	}

	public static void main(String[] args) {
		new Test1().sum(10f, 10);
		new Test1().sum(null, 10);
		Interface1.sub();
		System.out.println(Interface1.PI_APP);
	}

	private void sum(final String s1, double d) {
		System.out.println("Sum with final String s1, double d");
	}

}