package com.java.designpatterns.service.locator;

public class ServiceOne implements Service {

	public void execute() {
		System.out.println("Executing ServiceOne");
	}

	@Override
	public String getName() {
		return "ServiceOne";
	}

}