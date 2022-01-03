package com.java.concepts;

import com.java.concepts.OuterClass.InnerClass1;
import com.java.concepts.OuterClass.StaticInnerClass;

class OuterClass {
	String myName = "outerclass";
	private static String staticName = "outerclass";

	private class InnerClass {

		String myName = "innerClass";

		void printNames() {
			System.out.println(
					"I can access both static & non-static members of my outer class : " + staticName + " " + myName);
		}
	}
	
	public class InnerClass1 {

		String myName = "innerClass1";

		void printNames() {
			System.out.println(
					"I can access both static & non-static members of my outer class as public class : " + staticName + " " + myName);
		}
	}

	void createInnerClassInstance() {
		// Creating inner class instance
		InnerClass ic = new InnerClass();
		ic.printNames();
	}

	static class StaticInnerClass {

		String myName = "staticInnerClass";

		void printName() {
			System.out.println("I can access static members of my outerclass but not non-static ones: " + staticName);
		}
		
		static void print() {
			System.out.println("In inner static class");
		}
	}
}

public class InnerClassConcept {

	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		outerClass.createInnerClassInstance();
		
		InnerClass1 in = new OuterClass().new InnerClass1();
		in.printNames();
		
		StaticInnerClass s = new StaticInnerClass();
		s.printName();
		
		StaticInnerClass.print();
	}
	
}
