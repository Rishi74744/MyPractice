package com.java.designpatterns.singleton;

public class BillPughSingleton {

	private BillPughSingleton(){
	}
	
	private static class SingletonHelper{
		private static final BillPughSingleton BILL_PUGH_SINGLETON = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance(){
		return SingletonHelper.BILL_PUGH_SINGLETON;
	}
	
}
