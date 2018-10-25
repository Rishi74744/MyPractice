package com.java.designpatterns.strategy;

public class PayPal implements Payment {

	private String emailId;
	private String password;
	
	public PayPal(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}
	
	
	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with pay pal");
	}

}
