package com.java.designpatterns.service.locator;

public class InitialContext {

	public Object lookup(String name) {
		if (name.equalsIgnoreCase("ServiceOne")) {
			System.out.println("Creating a new ServiceOne object");
			return new ServiceOne();
		} else if (name.equalsIgnoreCase("ServiceTwo")) {
			System.out.println("Creating a new ServiceTwo object");
			return new ServiceTwo();
		}
		return null;
	}

}