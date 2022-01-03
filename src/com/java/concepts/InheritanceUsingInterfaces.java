package com.java.concepts;

interface Interface1 {

	void print();

	default void printSomething() {
		System.out.println("Printing Something In Interface 1");
	}

	static void printStatic() {
		System.out.println("Printing Static In Interface 1");
	}
}

interface Interface2 {

	void print();

	default void printSomething() {
		System.out.println("Printing Something In Interface 2");
	}

	static void printStatic() {
		System.out.println("Printing Static In Interface 2");
	}
}

public class InheritanceUsingInterfaces implements Interface1, Interface2 {

	@Override
	public void print() {
		System.out.println("Print Overriden");

	}

	@Override
	public void printSomething() {
		Interface1.super.printSomething();
		System.out.println("Print Something Overriden");
	}

	public static void main(String[] args) {
		System.out.println("------------------------------ Printing using implementation class ------------------------------");
		InheritanceUsingInterfaces i1 = new InheritanceUsingInterfaces();
//		i1.print();
		i1.printSomething();

		System.out.println("------------------------------ Printing using Interface1 ------------------------------");
		Interface1 int1 = new InheritanceUsingInterfaces();
		int1.printSomething();
//		Interface1.printStatic();

		System.out.println("------------------------------ Printing using Interface2 ------------------------------");
		Interface2 int2 = new InheritanceUsingInterfaces();
		int2.printSomething();
//		Interface2.printStatic();

	}

}
