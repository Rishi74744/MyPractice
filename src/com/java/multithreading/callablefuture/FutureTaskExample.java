package com.java.multithreading.callablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskExample {

	public static void main(String[] args) {
		MyCallableJavaFuture callable1 = new MyCallableJavaFuture(1000);
		MyCallableJavaFuture callable2 = new MyCallableJavaFuture(2000);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);

		while (true) {
			try {
				if (futureTask1.isDone() && futureTask2.isDone()) {
					System.out.println("Done");
					// shut down executor service
					executor.shutdown();
					return;
				}

				if (!futureTask1.isDone()) {
					// wait indefinitely for future task to complete
					System.out.println("FutureTask1 output=" + futureTask1.get());
				}

				System.out.println("Waiting for FutureTask2 to complete");
				String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
				if (s != null) {
					System.out.println("FutureTask2 output=" + s);
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				// do nothing
			}
		}

	}

}

class MyFuture implements Future<String> {

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String get() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}

}