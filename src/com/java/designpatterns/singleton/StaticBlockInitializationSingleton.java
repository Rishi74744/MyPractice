package com.java.designpatterns.singleton;

/**
 * Its implementation is similar to that of Eager initialized singleton but it
 * provides exception handling in static block Instance is created when class is
 * loaded.
 * 
 * @author Rishi
 *
 */
public class StaticBlockInitializationSingleton {

	private static StaticBlockInitializationSingleton staticBlockInitializationSingleton;

	private StaticBlockInitializationSingleton() {
	}

	static {
		try {
			staticBlockInitializationSingleton = new StaticBlockInitializationSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception in creating class instance");
		}
	}

	public static StaticBlockInitializationSingleton getInstance() {
		return staticBlockInitializationSingleton;
	}
}
