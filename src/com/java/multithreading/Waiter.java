package com.java.multithreading;

import java.util.Calendar;

public class Waiter implements Runnable {

	private Message message;

	public Waiter(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		synchronized (message) {
			try {
				System.out.println(threadName + " Waiting to get notified at : " + Calendar.getInstance().getTime());
				message.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " notified at : " + Calendar.getInstance().getTime());
			System.out.println(threadName + " Processing on message : " + message.getMessage());
		}

	}

}