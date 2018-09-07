package com.java.multithreading;

import java.util.concurrent.TimeUnit;

public class ThreadAsLambda {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1");
			}
		});
		thread.start();
	}

}
