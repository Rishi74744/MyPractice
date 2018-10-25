package com.java.concepts;

public class InnerClasses {

	class InstanceInnerClass {
		public int a = 10;
		public static final String s1 = "ABS";

		public void m1() {
			System.out.println("instance m1 in instance inner class");
		}

	}

	static class StaticInnerClass {
		public int a = 20;
		public static String s1 = "UQWID";

		public void m1() {
			System.out.println("instance m1 in static inner class");
		}

		public static void m2() {
			System.out.println("static m2 in static innner class");
		}

	}

	public void m1() {
		class LocalClass {
			private int a = 30;
			public static final String s1 = "ABCD";

			public String m1() {
				return "m1 in local class";
			}
		}

		LocalClass localClass = new LocalClass();
		System.out.println("Local Class a : " + localClass.a);
		System.out.println("Local Class s1 : " + LocalClass.s1);
		System.out.println("Calling m1() : " + localClass.m1());
	}

}