package com.java.multithreading.executors;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceThread {

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
		System.out.println("Current Time : " + new Date());
		for (int i = 0; i < 3; i++) {
			TimeUnit.SECONDS.sleep(2);
			WorkerThread worker = new WorkerThread("Heavy Lifting - " + i);
			executor.schedule(worker, 10, TimeUnit.SECONDS);
		}
		TimeUnit.SECONDS.sleep(5);
		List<Runnable> run = executor.shutdownNow();
		for(Runnable r : run) {
			executor.schedule(r, 10, TimeUnit.SECONDS);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Waiting For Tasks to Finish");
		}
		System.out.println("All Thread Processing Finished");
	}

}
