package com.java6;

public interface TestInterface {

	public static final int a = 10;

	class A {
		public static int b;
		static {
			b = 20;
		}

		public void show() {
			System.out.println("Value of b : " + b);
		}
	}

	static class B extends A {
		static int a;
		static int b;
		static {
			a = 32;
			b = 50;
		}

		public void show() {
			System.out.println("Value of b : " + b);
		}
	}
}
