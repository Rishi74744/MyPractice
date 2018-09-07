package com.java.multithreading;

public class WaitNotifyAndNotifyAll {

	public static void main(String[] args) {
		Message message = new Message("Process this");
		Waiter waiter1 = new Waiter(message);
		new Thread(waiter1, "waiter1").start();

		Waiter waiter2 = new Waiter(message);
		new Thread(waiter2, "waiter2").start();

		Notifier notifier = new Notifier(message);
		new Thread(notifier, "notifier").start();

		System.out.println("All threads started");

	}

}
