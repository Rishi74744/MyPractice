package com.java.multithreading;

public class ThreadJoin {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable(), "t1");
		Thread t2 = new Thread(new MyRunnable(), "t2");
		Thread t3 = new Thread(new MyRunnable(), "t3");
		t1.start();
		try {
			t1.join(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			t1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		t3.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("All thread execution finished. Exiting main thread.");
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread started:::" + Thread.currentThread().getName());
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread ended:::" + Thread.currentThread().getName());
	}

}
