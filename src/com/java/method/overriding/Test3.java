package com.java.method.overriding;

import java.sql.SQLException;

import com.java.method.overloading.Interface1;
import com.java.method.overloading.Interface2;

public class Test3 implements Interface1, Interface2 {

	@Override
	public void method1() throws SQLException {
		// TODO Auto-generated method stub
		Interface1.super.method1();
	}

	@Override
	public strictfp void test() {
		// TODO Auto-generated method stub
		Interface2.super.test();
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
