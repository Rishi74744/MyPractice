package com.java6;

import java.util.Random;

public class MonitorModel {
	public static int count = 0;
	public static void main(String[] args) {
		new RemoteHost("example 1");
		new RemoteHost("example 2");
	}
}

class MonitoredObject {
}

class RemoteHost extends MonitoredObject implements Runnable {
	String name;
	int delay;

	RemoteHost(String n) {
		name = n;
		new Thread(this).start();
	}

	public void run() {
		Random r = new Random();
		while (true) {
			try {
				int delay = r.nextInt(1000);
				System.out.format("Line #%d from RemoteHost '%s', after %d-milliseconds.\n", MonitorModel.count, name, delay);
				Thread.currentThread().sleep(delay);
			} catch (InterruptedException ie) {
				System.out.println("Surprise!!");
			}
			MonitorModel.count++;
		}
	}
}