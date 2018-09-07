package com.java.method.overloading;

import java.sql.SQLException;

public interface Interface1 {

	double PI_APP = 3.14;
	
	int sum();

	strictfp default void test(){
		
	}

	default void method1() throws SQLException {
		System.out.println("Method 1 in Interface1");
	}

	static void sub() {
		System.out.println("Static sub in Interface1");
	}

}
