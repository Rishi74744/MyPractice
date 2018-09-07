package com.java.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorService {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread(Integer.toString(i));
			executorService.execute(worker);
		}
		executorService.shutdown();
		while (!executorService.isTerminated()) {
			Thread.sleep(2000);
			System.out.println("Finishing all threads");
		}
		System.out.println("All thread execution finished!");
	}

}