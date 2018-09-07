package com.java.multithreading.executors;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadRejectionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		System.out.println(runnable.toString() + " is rejected");
	}

}