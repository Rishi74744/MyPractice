package com.java.concepts;

class A {
	
}

public class OverloadingConcept {

	public void print(String s) {
		System.out.println("In String");
		System.out.println(s);
	}
	
	public void print(Object o) {
		System.out.println("In String");
		System.out.println(o);
	}

	public static void main(String[] args) {
		OverloadingConcept ov = new OverloadingConcept();
		ov.print(null);
	}

}
