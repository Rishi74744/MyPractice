package com.java6;

public class ASimpleThread {

	public static void main(String[] args) {
		ThreadExample threadExample1 = new ThreadExample("A", 500);
		ThreadExample threadExample2 = new ThreadExample("B", 1500);
		ThreadExample threadExample3 = new ThreadExample("C", 500);
		threadExample1.start();
		threadExample2.start();
		threadExample3.start();
	}
	
}

class ThreadExample extends Thread {
	private int delay;

	public ThreadExample(String label, int d) {
		super("Thread '" + label + "'");
		delay = d;
	}

	public void run() {
		try {
			for (int i = 1, j = 1; j < 20; j++, i++) {
				System.out.format("Line #%d from %s\n", i, getName());
				Thread.currentThread().sleep(delay);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}