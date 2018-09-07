package com.java.multithreading;

public class Notifier implements Runnable {

	private Message message;

	public Notifier(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " notifier started");
		try {
			Thread.sleep(1000);
			synchronized (message) {
				message.setMessage(threadName + " Work Done!");
				message.notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
