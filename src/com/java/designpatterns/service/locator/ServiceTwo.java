package com.java.designpatterns.service.locator;

public class ServiceTwo implements Service {

	public void execute() {
		System.out.println("Executing ServiceTwo");
	}

	@Override
	public String getName() {
		return "ServiceTwo";
	}

}