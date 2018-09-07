package com.java.method.overriding;

import java.sql.SQLException;

public class Test2 extends Test1 {

	int a = 20;

	@Override
	public void printF() {
		System.out.println(a);
	}

	public static void main(String[] args) throws SQLException {
		System.out.println("<--------------------------1------------------------>");
		Test1 t1 = new Test1();
		System.out.println(t1.a);
		System.out.println(t1.d);
		t1.printF();
		System.out.println("<--------------------------2------------------------>");
		Test2 t2 = new Test2();
		System.out.println(t2.a);
		System.out.println(t2.d);
		t2.printF();
		System.out.println("<--------------------------3------------------------>");
		Test1 t11 = new Test2();
		System.out.println(t11.a);
		System.out.println(t11.d);
		t11.printF();
		System.out.println("<--------------------------4------------------------>");
		Test2 t21 = new Test2();
		System.out.println(t21.a);
		System.out.println(t21.d);
		t21.printF();

	}

}