package com.java.designpatterns.service.locator;

public class ServiceLocatorPatternDemo {

	public static void main(String[] args) {
		Service service = ServiceLocator.getService("ServiceOne");
		service.execute();

		service = ServiceLocator.getService("ServiceTwo");
		service.execute();

		service = ServiceLocator.getService("ServiceOne");
		service.execute();

		service = ServiceLocator.getService("ServiceTwo");
		service.execute();
	}

}