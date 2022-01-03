package com.java.concepts;

interface InterfaceInherit {
	default void print() {
		System.out.println("In InterfaceInherit");
	}
}

class InClass1 {
	public void print() {
		System.out.println("In Inclass1");
	}
}

public class InheritanceUsingClassAndInterface extends InClass1 implements InterfaceInherit {

	public static void main(String[] args) {
		InheritanceUsingClassAndInterface i = new InheritanceUsingClassAndInterface();
		i.print();
	}

}
