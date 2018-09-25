package com.java6;

public class Test {

	public static void main(String[] args) {
		/*
		 * TestInterface.A a = new TestInterface.A(); a.show();
		 * 
		 * TestInterface.B b = new TestInterface.B(); b.show();
		 */
		String s7 = "AQWS".intern();
		String s1 = "ABC";
		String s = "?ABC";
		String s2 = "?ABC".substring(1);
		String s3 = "ABC";
		String s4 = s2.intern();
		String s5 = new String("ABC");
		String s6 = s5.intern();
		System.out.println(s7);
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s2);
		System.out.println(s1 == s4);
		System.out.println(s.hashCode());
		System.out.println("?ABC".intern().hashCode());
		System.out.println(s5 == s6);
		System.out.println(s1 == s6);

		StringBuffer str1 = new StringBuffer("Hello");
		System.out.println(str1.length());
		System.out.println(str1.capacity());
		str1.append("This is just a test for String Buffer");
		System.out.println(str1.length());
		System.out.println(str1.capacity());
		str1.append("...");
		System.out.println(str1.length());
		System.out.println(str1.capacity());
	}

}
