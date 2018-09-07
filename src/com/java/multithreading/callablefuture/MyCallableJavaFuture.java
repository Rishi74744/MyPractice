package com.java.multithreading.callablefuture;

import java.util.concurrent.Callable;

public class MyCallableJavaFuture implements Callable<String> {

	private long waitTime;

	public MyCallableJavaFuture(int timeInMillis) {
		this.waitTime = timeInMillis;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}
}