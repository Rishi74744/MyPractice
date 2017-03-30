package com.java.designpatterns.singleton;

/**
 * In thread safe singleton, we make the getInstance() synchronized which makes
 * it thread safe but it also reduces performance.
 * 
 * @author Rishi
 *
 */
public class ThreadSafeSingleton {

	private static ThreadSafeSingleton threadSafeSingleton;

	private ThreadSafeSingleton() {
	}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (threadSafeSingleton == null) {
			threadSafeSingleton = new ThreadSafeSingleton();
		}
		return threadSafeSingleton;
	}
}
