package com.java.designpatterns.singleton;

/**
 * In case of lazy initialization, instance is created when first time
 * getInstance() is called. This approach is fine for single threaded
 * environment. In multithreaded environment, if multiple threads call
 * getInstance() then singleton will be destroyed and different threads will get
 * different instances.
 * 
 * @author Rishi
 *
 */
public class LazyInitializationSingleton {

	private static LazyInitializationSingleton lazyInitializationSingleton;

	private LazyInitializationSingleton() {
	}

	public static LazyInitializationSingleton getInstance() {
		if (lazyInitializationSingleton == null) {
			lazyInitializationSingleton = new LazyInitializationSingleton();
		}
		return lazyInitializationSingleton;
	}

}
